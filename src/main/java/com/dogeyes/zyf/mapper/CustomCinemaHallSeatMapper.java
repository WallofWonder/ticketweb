package com.dogeyes.zyf.mapper;

import com.dogeyes.zyf.pojo.CinemaHallSeat;

import java.util.List;

/**
 * @author ZYF
 * @create 2021-5-4 21:03
 */
public interface CustomCinemaHallSeatMapper {

    List<CinemaHallSeat> listSeatsByOrder(long orderId);
}
