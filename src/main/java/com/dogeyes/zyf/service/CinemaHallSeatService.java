package com.dogeyes.zyf.service;

import com.dogeyes.zyf.pojo.CinemaHallSeat;

import java.util.List;

/**
 * @author ZYF
 * @create 2021-4-30 14:43
 */
public interface CinemaHallSeatService {

    /**
     * 列出场次已购座位
     *
     * @param sessionId 场次id
     * @return 座位列表
     */
    List<CinemaHallSeat> listSeatsBySession(long sessionId);
}
