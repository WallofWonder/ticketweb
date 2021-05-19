package com.dogeyes.zyf.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.dogeyes.zyf.jwt.AccountLoginToken;
import com.dogeyes.zyf.jwt.CurrentAccount;
import com.dogeyes.zyf.jwt.PassToken;
import com.dogeyes.zyf.pojo.Account;
import com.dogeyes.zyf.pojo.Oder;
import com.dogeyes.zyf.resource.alipay.AliRefundReq;
import com.dogeyes.zyf.resource.common.PageParamResource;
import com.dogeyes.zyf.resource.order.OrderListRes;
import com.dogeyes.zyf.resource.order.OrderReq;
import com.dogeyes.zyf.service.AlipayService;
import com.dogeyes.zyf.service.OrderService;
import com.dogeyes.zyf.util.AjaxResponse;
import com.dogeyes.zyf.util.CustomException;
import com.dogeyes.zyf.util.CustomExceptionType;
import com.dogeyes.zyf.util.OrderStatus;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

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

    @Resource(name = "alipayServiceImpl")
    AlipayService alipayService;

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

    @AccountLoginToken
    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    @ResponseBody
    Object checkOrder(long orderId) {
        int result = orderService.check(orderId, OrderStatus.PAID);
        if (result == 0) {
            return AjaxResponse.error(CustomExceptionType.NOT_FOUND, "订单不存在");
        }
        return AjaxResponse.success(result);
    }

    @PassToken
    @RequestMapping(value = "/listByAccount", method = RequestMethod.GET)
    @ResponseBody
    Object listOrders(long accountId) {
        List<OrderListRes> orderList = orderService.listOrder(accountId);
        return AjaxResponse.success(orderList);
    }

    @PassToken
    @RequestMapping(value = "/admin/list", method = RequestMethod.GET)
    @ResponseBody
    Object listOrders(@Valid PageParamResource page, long accountId) {
        PageInfo<List<OrderListRes>> listOrder = orderService.listOrder(page, accountId);
        return AjaxResponse.success(listOrder);
    }

    @PassToken
    @RequestMapping(value = "/refund", method = RequestMethod.POST)
    @ResponseBody
    Object refund(AliRefundReq req) throws AlipayApiException {
        AlipayTradeRefundResponse response = alipayService.refund(req);
        String code = response.getCode();
        if ("10000".equals(code)) {
            int check = orderService.check(req.getOrderId(), OrderStatus.CANCELED);
            if (check != 0) return AjaxResponse.success("退款成功！");
            return AjaxResponse.error(new CustomException(CustomExceptionType.SYSTEM_ERROR));
        }

        return AjaxResponse.error(CustomExceptionType.SYSTEM_ERROR, response.getSubMsg());
    }

    @PassToken
    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    @ResponseBody
    Object cancel(long orderId) {
        int check  = orderService.check(orderId, OrderStatus.CANCELED);
        if (check != 0) return AjaxResponse.success("取消成功！");
        return AjaxResponse.error(new CustomException(CustomExceptionType.SYSTEM_ERROR));
    }

    @PassToken
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    Object delete(long orderId) {
        int ok = orderService.delete(orderId);
        if (ok == 0) return AjaxResponse.error(CustomExceptionType.NOT_FOUND,"未找到订单信息");
        return AjaxResponse.success();
    }
}
