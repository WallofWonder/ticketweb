package com.dogeyes.zyf.controller;

import com.dogeyes.zyf.jwt.AccountLoginToken;
import com.dogeyes.zyf.jwt.CurrentAccount;
import com.dogeyes.zyf.pojo.Account;
import com.dogeyes.zyf.pojo.Oder;
import com.dogeyes.zyf.resource.order.OrderReq;
import com.dogeyes.zyf.service.OrderService;
import com.dogeyes.zyf.util.AjaxResponse;
import com.dogeyes.zyf.util.CustomExceptionType;
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

    @AccountLoginToken
    @RequestMapping(value = "/initOrder",method = RequestMethod.POST)
    @ResponseBody
    Object initOrder(@RequestBody OrderReq orderReq) {
        Long orderId = orderService.initOrder(orderReq);
        if (orderId == -1L) {
            return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, "您已在该场次购票！");
        }
        return AjaxResponse.success(orderId);
    }

    @AccountLoginToken
    @RequestMapping(value = "/orderInfo", method = RequestMethod.GET)
    @ResponseBody
    Object getOrderInfo(long orderId, @CurrentAccount Account account) {
        Oder order = orderService.getById(orderId, account.getId());
        if (order == null) {
            return AjaxResponse.error(CustomExceptionType.NOT_FOUND, "您的账户下没有找到此订单！");
        }
        return AjaxResponse.success(order);
    }
}
