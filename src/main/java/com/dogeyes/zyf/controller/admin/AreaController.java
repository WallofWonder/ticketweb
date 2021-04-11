package com.dogeyes.zyf.controller.admin;

import com.dogeyes.zyf.resource.PageParamResource;
import com.dogeyes.zyf.resource.ResponseResource;
import com.dogeyes.zyf.service.AreaService;
import com.dogeyes.zyf.util.BindingResultUtil;
import com.dogeyes.zyf.util.JsonResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public Object selectProvinces(PageParamResource page, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JsonResult.unprocessableEntity("error in validating", BindingResultUtil.getErrorList(bindingResult));
        }
        return new ResponseResource(JsonResult.ok(areaService.selectProvinces(page)),20000);
    }

    @GetMapping("/city/select")
    public Object selectCities(PageParamResource page, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JsonResult.unprocessableEntity("error in validating", BindingResultUtil.getErrorList(bindingResult));
        }
        return new ResponseResource(JsonResult.ok(areaService.selectCities(page)),20000);
    }

    @GetMapping("list")
    public Object listAll(PageParamResource page, BindingResult bindingResult) {
        System.out.println(page);
        if (bindingResult.hasErrors()) {
            return JsonResult.unprocessableEntity("error in validating", BindingResultUtil.getErrorList(bindingResult));
        }
        return new ResponseResource(JsonResult.ok(areaService.listAll(page)), 20000);
    }
}
