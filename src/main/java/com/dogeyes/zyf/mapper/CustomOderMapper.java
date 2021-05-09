package com.dogeyes.zyf.mapper;

import com.dogeyes.zyf.resource.order.OrderListRes;

import java.util.List;

/**
 * @author ZYF
 * @create 2021-5-2 21:23
 */
public interface CustomOderMapper {
    List<OrderListRes> listOrderById(Long accountId);
}
