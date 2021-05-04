package com.dogeyes.zyf.service.impl;

import com.dogeyes.zyf.mapper.CinemaHallSeatMapper;
import com.dogeyes.zyf.mapper.CustomCinemaHallSeatMapper;
import com.dogeyes.zyf.pojo.CinemaHallSeat;
import com.dogeyes.zyf.pojo.CinemaHallSeatExample;
import com.dogeyes.zyf.service.CinemaHallSeatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZYF
 * @create 2021-4-30 14:44
 */
@Service
public class CinemaHallSeatServiceImpl implements CinemaHallSeatService {
    @Resource
    CinemaHallSeatMapper mapper;

    @Resource
    CustomCinemaHallSeatMapper customMapper;

    @Override
    public List<CinemaHallSeat> listSeatsBySession(long sessionId) {
        CinemaHallSeatExample example = new CinemaHallSeatExample();
        CinemaHallSeatExample.Criteria criteria = example.createCriteria();
        criteria.andHallSessionIdEqualTo(sessionId);
        return mapper.selectByExample(example);
    }

    @Override
    public List<CinemaHallSeat> listSeatsByOrder(long orderId) {

        return customMapper.listSeatsByOrder(orderId);
    }
}
