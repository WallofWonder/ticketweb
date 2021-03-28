package com.dogeyes.zyf.service;

import com.dogeyes.zyf.pojo.Area;
import com.dogeyes.zyf.resource.PageParamResource;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author ZYF
 * @create 2021-3-26 16:57
 */
public interface AreaService {

    /**
     * 获取省份列表
     *
     * @param page   分页参数
     * @return 省份列表
     */
    PageInfo<List<Area>> listProvince(PageParamResource page);


    /**
     * 获取城市列表
     *
     * @param page   分页参数
     * @return 地域列表
     */
    PageInfo<List<Area>> listCityByProvince(PageParamResource page, Long provinceId);

    /**
     * 获取区划列表
     *
     * @param page   分页参数
     * @return 区划列表
     */
    PageInfo<List<Area>> listAreaByCity(PageParamResource page, Long cityId);

}
