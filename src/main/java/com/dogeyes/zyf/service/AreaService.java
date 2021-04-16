package com.dogeyes.zyf.service;

import com.dogeyes.zyf.pojo.Area;
import com.dogeyes.zyf.resource.AreaListResource;
import com.dogeyes.zyf.resource.CitySelectProvince;
import com.dogeyes.zyf.resource.PageParamResource;
import com.dogeyes.zyf.resource.ProvinceSelectResource;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author ZYF
 * @create 2021-3-26 16:57
 */
public interface AreaService {

    /**
     * 获取级联选择器-所有省份选项
     *
     * @return 所有省份选项
     */
    List<ProvinceSelectResource> selectProvinces();


    /**
     * 获取级联选择器-所有城市选项
     * @return 城市选项
     */
    List<CitySelectProvince> selectCities();

    /**
     * 按照省份获取城市列表
     *
     * @param page 分页参数
     * @return 地域列表
     */
    PageInfo<List<Area>> listCityByProvince(PageParamResource page, Long provinceId);

    /**
     * 按照城市获取区划列表
     *
     * @param page 分页参数
     * @return 区划列表
     */
    PageInfo<List<Area>> listAreaByCity(PageParamResource page, Long cityId);

    /**
     * 获取所有列表
     *
     * @param page 分页参数
     * @return 所有列表
     */
    PageInfo<List<AreaListResource>> listAll(PageParamResource page);

    /**
     * 更新地域
     *
     * @param area 地域
     * @return <tt>1</tt> 更新成功；<tt>-1</tt> 更新失败
     */
    int updateArea(Area area);

}
