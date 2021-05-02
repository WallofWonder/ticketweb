package com.dogeyes.zyf.service.impl;

import com.dogeyes.zyf.mapper.CinemaHallSeatMapper;
import com.dogeyes.zyf.mapper.CustomOderMapper;
import com.dogeyes.zyf.mapper.OderMapper;
import com.dogeyes.zyf.mapper.OrderItemMapper;
import com.dogeyes.zyf.pojo.CinemaHallSeat;
import com.dogeyes.zyf.pojo.Oder;
import com.dogeyes.zyf.pojo.OrderItem;
import com.dogeyes.zyf.resource.order.OrderReq;
import com.dogeyes.zyf.resource.order.SessionSeatReq;
import com.dogeyes.zyf.service.OrderService;
import com.dogeyes.zyf.util.OrderUtil;
import com.dogeyes.zyf.util.PropertyMapperUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author ZYF
 * @create 2021-5-2 20:31
 */
@Service
@Transactional(rollbackFor = Throwable.class)
public class OrderServiceImpl implements OrderService {

    @Resource
    OderMapper oderMapper;

    @Resource
    OrderItemMapper orderItemMapper;

    @Resource
    CinemaHallSeatMapper cinemaHallSeatMapper;

    @Override
    public Long initOrder(OrderReq orderReq) {
        Date curDate = new Date();
        Long orderId = OrderUtil.generateOrderId(orderReq.getAccountId(), orderReq.getCinemaHallSessionId());

        Oder oder = new Oder();
        PropertyMapperUtil.map(orderReq, oder);
        oder.setId(orderId);
        oder.setCreateTime(curDate);
        oder.setUpdateTime(curDate);
        oder.setNum(1);
        oder.setDbStatus(0); // 未付款

        oderMapper.insert(oder);

        for (SessionSeatReq s : orderReq.getSeats()) {
            CinemaHallSeat seat = new CinemaHallSeat();

            PropertyMapperUtil.map(s, seat);
            seat.setCreateTime(curDate);
            seat.setUpdateTime(curDate);
            seat.setHallSessionId(orderReq.getCinemaHallSessionId());
            cinemaHallSeatMapper.insertSelective(seat);

            OrderItem item = new OrderItem();
            item.setCreateTime(curDate);
            item.setUpdateTime(curDate);
            item.setMoney(s.getPrice());
            item.setCinemaHallSeatId(seat.getId());
            item.setOrderId(orderId);
            orderItemMapper.insertSelective(item);
        }
        return orderId;
    }
}
