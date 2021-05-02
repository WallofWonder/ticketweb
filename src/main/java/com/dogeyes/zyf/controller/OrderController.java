package com.dogeyes.zyf.controller;

import com.dogeyes.zyf.resource.order.OrderReq;
import com.dogeyes.zyf.service.OrderService;
import com.dogeyes.zyf.util.AjaxResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author ZYF
 * @create 2021-5-1 10:28
 */
@RestController
@RequestMapping("orders")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OrderController {

    @Resource(name = "orderServiceImpl")
    OrderService orderService;

    // todo 生成订单
    @RequestMapping(value = "/initOrder",method = RequestMethod.POST)
    @ResponseBody
    Object initOrder(@RequestBody OrderReq orderReq) {
        return AjaxResponse.success(orderService.initOrder(orderReq));
    }
}
