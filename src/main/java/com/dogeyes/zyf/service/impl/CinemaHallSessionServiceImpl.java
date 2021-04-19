package com.dogeyes.zyf.service.impl;

import com.dogeyes.zyf.mapper.CinemaHallSessionMapper;
import com.dogeyes.zyf.pojo.CinemaHallSession;
import com.dogeyes.zyf.pojo.CinemaHallSessionExample;
import com.dogeyes.zyf.resource.hallsession.HallSessionReqResource;
import com.dogeyes.zyf.service.CinemaHallSessionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZYF
 * @create 2021-4-19 10:40
 */
@Service
@Transactional(rollbackFor = Throwable.class)
public class CinemaHallSessionServiceImpl implements CinemaHallSessionService {
    @Resource
    CinemaHallSessionMapper mapper;

    @Override
    public List<CinemaHallSession> listShowBy(HallSessionReqResource resource) {
        CinemaHallSessionExample example = new CinemaHallSessionExample();
        CinemaHallSessionExample.Criteria criteria = example.createCriteria();
        criteria.andMovieIdEqualTo(resource.getMovieid())
                .andCinemaIdEqualTo(resource.getCinemaid())
                .andShowDateEqualTo(resource.getShowdate());
        return mapper.selectByExample(example);
    }
}
