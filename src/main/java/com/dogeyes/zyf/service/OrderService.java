package com.dogeyes.zyf.service;

import com.dogeyes.zyf.pojo.Oder;
import com.dogeyes.zyf.resource.common.PageParamResource;
import com.dogeyes.zyf.resource.order.OrderListRes;
import com.dogeyes.zyf.resource.order.OrderReq;
import com.dogeyes.zyf.util.OrderStatus;
import com.github.pagehelper.PageInfo;

import java.util.List;

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
     * @param orderId   订单id
     * @param accountId 账号id
     * @return 订单信息
     */
    Oder getById(long orderId, long accountId);

    /**
     * 切换订单状态
     *
     * @param orderId 订单号
     * @param status  状态
     * @return 成功或者失败
     */
    int check(long orderId, OrderStatus status);

    /**
     * 获取账户订单列表
     *
     * @param accountId 账户id
     * @return 订单列表
     */
    List<OrderListRes> listOrder(long accountId);

    /**
     * 获取所有订单记录
     *
     * @param page      分页参数
     * @param accountId
     * @return 订单列表
     */
    PageInfo<List<OrderListRes>> listOrder(PageParamResource page, long accountId);

    /**
     * 删除订单
     *
     * @param orderId 订单id
     * @return 删除行数
     */
    int delete(long orderId);

    /**
     * 获取排片场次下订单记录（不含已取消订单）
     *
     * @param page 分页参数
     * @param sessionId 排片场次
     * @return 订单列表
     */
    PageInfo<List<OrderListRes>> listOrderBySes(PageParamResource page, long sessionId);
}
