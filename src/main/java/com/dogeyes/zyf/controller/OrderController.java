package com.dogeyes.zyf.controller;

import com.dogeyes.zyf.util.AjaxResponse;
import org.springframework.web.bind.annotation.*;

/**
 * @author ZYF
 * @create 2021-5-1 10:28
 */
@RestController
@RequestMapping("orders")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OrderController {
    // todo 生成订单
    @RequestMapping(value = "/initOrder",method = RequestMethod.POST)
    @ResponseBody
    Object initOrder() {
        return AjaxResponse.success();
    }
}
