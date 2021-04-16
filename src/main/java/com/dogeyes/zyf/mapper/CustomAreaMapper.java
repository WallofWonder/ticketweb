package com.dogeyes.zyf.mapper;

import com.dogeyes.zyf.resource.area.AreaListResource;
import com.dogeyes.zyf.resource.common.CitySelectProvince;
import com.dogeyes.zyf.resource.common.ProvinceSelectResource;

import java.util.List;

/**
 * @author ZYF
 * @create 2021-4-11 10:39
 */
public interface CustomAreaMapper {
    List<AreaListResource> listAll();
    List<ProvinceSelectResource> selectProvinces();
    List<CitySelectProvince> selectCities();
}
