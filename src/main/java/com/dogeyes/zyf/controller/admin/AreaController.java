package com.dogeyes.zyf.controller.admin;

import com.dogeyes.zyf.resource.PageParamResource;
import com.dogeyes.zyf.service.AreaService;
import com.dogeyes.zyf.util.AjaxResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @GetMapping("/province/select")
    public @ResponseBody
    Object selectProvinces() {
        return AjaxResponse.success(areaService.selectProvinces());
    }

    @GetMapping("/city/select")
    public @ResponseBody Object selectCities() {
        return AjaxResponse.success(areaService.selectCities());
    }

    @GetMapping("list")
    public @ResponseBody Object listAll(PageParamResource page) {
        return AjaxResponse.success(areaService.listAll(page));
    }
}
