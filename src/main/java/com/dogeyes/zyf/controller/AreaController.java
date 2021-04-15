package com.dogeyes.zyf.controller;

import com.dogeyes.zyf.resource.PageParamResource;
import com.dogeyes.zyf.service.AreaService;
import com.dogeyes.zyf.util.AjaxResponse;
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
}
