package com.dogeyes.zyf.service.impl;

import com.dogeyes.zyf.mapper.CinemaHallSeatMapper;
import com.dogeyes.zyf.mapper.CustomOderMapper;
import com.dogeyes.zyf.mapper.OderMapper;
import com.dogeyes.zyf.mapper.OrderItemMapper;
import com.dogeyes.zyf.pojo.*;
import com.dogeyes.zyf.resource.order.OrderListRes;
import com.dogeyes.zyf.resource.order.OrderReq;
import com.dogeyes.zyf.resource.order.SessionSeatReq;
import com.dogeyes.zyf.service.OrderService;
import com.dogeyes.zyf.util.OrderStatus;
import com.dogeyes.zyf.util.OrderUtil;
import com.dogeyes.zyf.util.PropertyMapperUtil;
import com.dogeyes.zyf.util.SeatStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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
    CustomOderMapper customOderMapper;

    @Resource
    OrderItemMapper orderItemMapper;

    @Resource
    CinemaHallSeatMapper cinemaHallSeatMapper;

    @Override
    public Long initOrder(OrderReq orderReq) {
        if (isExist(orderReq)) return -1L;

        Date curDate = new Date();
        Long orderId = OrderUtil.generateOrderId(orderReq.getAccountId(), orderReq.getCinemaHallSessionId());

        Oder oder = new Oder();
        PropertyMapperUtil.map(orderReq, oder);
        oder.setId(orderId);
        oder.setCreateTime(curDate);
        oder.setUpdateTime(curDate);
        oder.setNum(1);
        oder.setDbStatus(OrderStatus.UNPAID.getValue()); // 未付款

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

    @Override
    public Oder getById(long orderId, long accountId) {
        Oder oder = oderMapper.selectByPrimaryKey(orderId);
        if (oder == null || oder.getAccountId() != accountId) return null;
        return oder;
    }

    @Override
    public int check(long orderId, OrderStatus status) {
        int result = 0;

        // 更新订单状态
        OderExample oderExample= new OderExample();
        OderExample.Criteria orderCriteria = oderExample.createCriteria();
        orderCriteria.andIdEqualTo(orderId);
        Oder order = new Oder();
        order.setDbStatus(status.getValue());
        result += oderMapper.updateByExampleSelective(order, oderExample);

        // 根据订单号获取order_item记录
        OrderItemExample itemExample = new OrderItemExample();
        OrderItemExample.Criteria itemCriteria = itemExample.createCriteria();
        itemCriteria.andOrderIdEqualTo(orderId);
        List<OrderItem> orderItems = orderItemMapper.selectByExample(itemExample);

        // 根据order_item获取座位
        CinemaHallSeat seat = new CinemaHallSeat();
        switch (status){
            case UNPAID: seat.setStats(SeatStatus.LOCKED.getValue()); break;
            case PAID: seat.setStats(SeatStatus.PAID.getValue()); break;
            case CANCELED: seat.setStats(SeatStatus.CANCELED.getValue()); break;
        }
        for (OrderItem item :
                orderItems) {
            seat.setId(item.getCinemaHallSeatId());
            result += cinemaHallSeatMapper.updateByPrimaryKeySelective(seat);
        }

        return result;
    }

    @Override
    public List<OrderListRes> listOrder(long accountId) {
        return customOderMapper.listOrderById(accountId);
    }

    /**
     * 判断该账户是否在该场次买过票
     *
     * @param req 订单请求
     * @return 是否买过票
     */
    private boolean isExist(OrderReq req) {
        OderExample example = new OderExample();
        OderExample.Criteria criteria = example.createCriteria();
        criteria.andAccountIdEqualTo(req.getAccountId())
                .andCinemaHallSessionIdEqualTo(req.getCinemaHallSessionId());
        List<Oder> orders = oderMapper.selectByExample(example);
        return !orders.isEmpty();
    }
}
