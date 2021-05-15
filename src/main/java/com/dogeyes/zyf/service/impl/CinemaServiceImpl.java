package com.dogeyes.zyf.service.impl;

import com.dogeyes.zyf.mapper.AreaMapper;
import com.dogeyes.zyf.mapper.CinemaMapper;
import com.dogeyes.zyf.mapper.CustomCinemaMapper;
import com.dogeyes.zyf.pojo.Area;
import com.dogeyes.zyf.pojo.Cinema;
import com.dogeyes.zyf.pojo.CinemaExample;
import com.dogeyes.zyf.resource.common.PageParamResource;
import com.dogeyes.zyf.service.AreaService;
import com.dogeyes.zyf.service.CinemaService;
import com.dogeyes.zyf.util.PageSortHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ZYF
 * @create 2021-4-17 1:32
 */
@Service
@Transactional(rollbackFor = Throwable.class)
public class CinemaServiceImpl implements CinemaService {
    @Resource
    CinemaMapper cinemaMapper;

    @Resource
    CustomCinemaMapper customCinemaMapper;

    @Resource
    AreaMapper areaMapper;

    @Resource(name = "areaServiceImpl")
    AreaService areaService;

    @Override
    public void fetchInfo(List<Cinema> cinemas) {
        for (Cinema cinema : cinemas) {
            String address = cinema.getAddress();
            String areaName = address.substring(0, 2);
            List<Area> areas = areaService.selectByName(areaName);
            if (areas != null && areas.size() > 0)
                cinema.setAreaId(areas.get(0).getId());
            cinema.setCreateTime(new Date());
            cinema.setUpdateTime(new Date());
            cinemaMapper.insertSelective(cinema);
        }
    }

    @Override
    public Cinema selectCinemaById(int id) {
        return cinemaMapper.selectByPrimaryKey((long) id);
    }

    @Override
    public List<Cinema> listByMovie(long movieid) {
        return customCinemaMapper.listByMovie(movieid);
    }

    @Override
    public List<Cinema> listByArea(Long areaid) {
        CinemaExample cinemaExample = new CinemaExample();
        CinemaExample.Criteria cinemaExampleCriteria = cinemaExample.createCriteria();
        if (areaid != null) {
            // 用于判断是城市还是区域代码
            Area area = areaService.getById(areaid);
            if (area == null) return new ArrayList<>();

            if (area.getCityId() != 0L) {
                // 区域代码
                // System.out.println("area");
                cinemaExampleCriteria.andAreaIdEqualTo(areaid);
            }
            else if (area.getProvinceId() != 0L){
                // 城市代码
                // System.out.println("city");
                cinemaExampleCriteria.andCityIdEqualTo(areaid);
            }
            else {
                // 省份代码
                // System.out.println("province");
                cinemaExampleCriteria.andProvinceIdEqualTo(areaid);
            }

        }
        return cinemaMapper.selectByExample(cinemaExample);
    }

    @Override
    public PageInfo<List<Cinema>> list(PageParamResource page, String dbName, Long areaId) {
        CinemaExample example = new CinemaExample();
        CinemaExample.Criteria criteria = example.createCriteria();
        if (dbName != null) {
            criteria.andDbNameLike("%" + dbName + "%");
        }

        if (areaId != null) {
            // 用于判断是城市还是区域代码
            Area area = areaService.getById(areaId);

            if (area.getCityId() != 0L) {
                // 区域代码
                criteria.andAreaIdEqualTo(areaId);
            }
            else if (area.getProvinceId() != 0L){
                // 城市代码
                criteria.andCityIdEqualTo(areaId);
            }
            else {
                // 省份代码
                criteria.andProvinceIdEqualTo(areaId);
            }

        }
        PageSortHelper.pageAndSort(page, Cinema.class);
        List<Cinema> cinemas = cinemaMapper.selectByExample(example);
        return new PageInfo(cinemas);
    }

    @Override
    public int update(Cinema cinema) {
        cinema.setUpdateTime(new Date());
        return cinemaMapper.updateByPrimaryKeySelective(cinema);
    }
}
