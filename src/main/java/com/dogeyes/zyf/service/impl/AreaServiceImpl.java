package com.dogeyes.zyf.service.impl;

import com.dogeyes.zyf.mapper.AreaMapper;
import com.dogeyes.zyf.mapper.CustomAreaMapper;
import com.dogeyes.zyf.pojo.Area;
import com.dogeyes.zyf.resource.area.AreaListResource;
import com.dogeyes.zyf.resource.common.CitySelectProvince;
import com.dogeyes.zyf.resource.common.ProvinceSelectResource;
import com.dogeyes.zyf.resource.common.PageParamResource;
import com.dogeyes.zyf.service.AreaService;
import com.dogeyes.zyf.util.PageSortHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author ZYF
 * @create 2021-3-28 11:24
 */
@Service
@Transactional(rollbackFor = Throwable.class)
public class AreaServiceImpl implements AreaService {

    @Resource
    AreaMapper areaMapper;

    @Resource
    CustomAreaMapper customAreaMapper;

    @Override
    public List<ProvinceSelectResource> selectProvinces() {
        return customAreaMapper.selectProvinces();
    }

    @Override
    public List<CitySelectProvince>selectCities() {
        return customAreaMapper.selectCities();
    }

    @Override
    public PageInfo<List<Area>> listCityByProvince(PageParamResource page, Long provinceId) {
        return null;
    }

    @Override
    public PageInfo<List<Area>> listAreaByCity(PageParamResource page, Long cityId) {
        return null;
    }

    @Override
    public PageInfo<List<AreaListResource>> listAll(PageParamResource page) {
        PageSortHelper.pageAndSort(page, AreaListResource.class);
        List<AreaListResource> areas = customAreaMapper.listAll();
        return new PageInfo(areas);
    }

    @Override
    public int updateArea(Area area) {
        area.setUpdateTime(new Date());
        return areaMapper.updateByPrimaryKeySelective(area);
    }
}
