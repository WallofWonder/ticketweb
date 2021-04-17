package com.dogeyes.zyf.service.impl;

import com.dogeyes.zyf.mapper.AreaMapper;
import com.dogeyes.zyf.mapper.CinemaMapper;
import com.dogeyes.zyf.pojo.Area;
import com.dogeyes.zyf.pojo.Cinema;
import com.dogeyes.zyf.service.AreaService;
import com.dogeyes.zyf.service.CinemaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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

    @Resource(name = "areaServiceImpl")
    AreaService service;

    @Override
    public void fetchInfo(List<Cinema> cinemas) {
        for (Cinema cinema : cinemas) {
            String address = cinema.getAddress();
            String areaName = address.substring(0, 2);
            List<Area> areas = service.selectByName(areaName);
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
}
