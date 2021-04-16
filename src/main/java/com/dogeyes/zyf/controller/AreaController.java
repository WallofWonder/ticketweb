package com.dogeyes.zyf.controller;

import com.dogeyes.zyf.pojo.Area;
import com.dogeyes.zyf.resource.movie.PageParamResource;
import com.dogeyes.zyf.service.AreaService;
import com.dogeyes.zyf.util.AjaxResponse;
import com.dogeyes.zyf.util.CustomException;
import com.dogeyes.zyf.util.CustomExceptionType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 地域管理控制器
 *
 * @author ZYF
 * @create 2021-3-26 16:46
 */
@RestController
@RequestMapping("admin/areas")
public class AreaController {

    @Resource(name = "areaServiceImpl")
    AreaService areaService;

    @RequestMapping(value = "/province/select",method = RequestMethod.GET)
    public @ResponseBody
    Object selectProvinces() {
        return areaService.selectProvinces();
    }

    @RequestMapping(value = "/city/select", method = RequestMethod.GET)
    public @ResponseBody Object selectCities() {
        return areaService.selectCities();
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public @ResponseBody Object listAll(@Valid PageParamResource page) {
        return areaService.listAll(page);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody Object update(@RequestBody Area area) {
        int result = areaService.updateArea(area);
        if (result != 1) throw new CustomException(CustomExceptionType.SYSTEM_ERROR, "更新失败！");
        return AjaxResponse.success();
    }
}
