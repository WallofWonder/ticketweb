package com.dogeyes.zyf.service.impl;

import com.dogeyes.zyf.mapper.AreaMapper;
import com.dogeyes.zyf.pojo.Area;
import com.dogeyes.zyf.pojo.example.AreaExample;
import com.dogeyes.zyf.resource.AreaResource;
import com.dogeyes.zyf.resource.PageParamResource;
import com.dogeyes.zyf.service.AreaService;
import com.dogeyes.zyf.util.PageSortHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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

    @Override
    public PageInfo<List<Area>> listProvince(PageParamResource page) {
        AreaExample areaExample = new AreaExample();
        AreaExample.Criteria criteria = areaExample.createCriteria();
        criteria.andProvinceIdEqualTo(0L);

        PageSortHelper.pageAndSort(page, AreaResource.class);
        List<Area> areas = areaMapper.selectByExample(areaExample);
        return new PageInfo(areas);
    }

    @Override
    public PageInfo<List<Area>> listCityByProvince(PageParamResource page, Long provinceId) {
        return null;
    }

    @Override
    public PageInfo<List<Area>> listAreaByCity(PageParamResource page, Long cityId) {
        return null;
    }
}
