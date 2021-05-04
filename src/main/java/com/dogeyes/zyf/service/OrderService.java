package com.dogeyes.zyf.service;

import com.dogeyes.zyf.pojo.Oder;
import com.dogeyes.zyf.resource.order.OrderReq;

/**
 * @author ZYF
 * @create 2021-5-2 20:31
 */
public interface OrderService {

    /**
     * 生成订单
     *
     * @param orderReq 订单信息
     * @return orderId
     */
    Long initOrder(OrderReq orderReq);

    /**
     * 获取订单信息
     *
     * @param orderId 订单id
     * @param accountId 账号id
     * @return 订单信息
     */
    Oder getById(long orderId, long accountId);
}
