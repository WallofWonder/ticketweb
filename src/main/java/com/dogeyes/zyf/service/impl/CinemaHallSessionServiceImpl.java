package com.dogeyes.zyf.service.impl;

import com.dogeyes.zyf.mapper.CinemaHallSessionMapper;
import com.dogeyes.zyf.mapper.CustomCinemaHallSessionMapper;
import com.dogeyes.zyf.pojo.CinemaHallSession;
import com.dogeyes.zyf.pojo.CinemaHallSessionExample;
import com.dogeyes.zyf.resource.hallsession.HallSessionReqResource;
import com.dogeyes.zyf.resource.hallsession.HallSessionResResource;
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
    CinemaHallSessionMapper hallSessionMapper;

    @Resource
    CustomCinemaHallSessionMapper customHallSessionMapper;

    @Override
    public List<HallSessionResResource> listShowBy(HallSessionReqResource resource) {

        return customHallSessionMapper.listShowBy(resource);
    }

    @Override
    public List<String> getShowDates(long movieid) {
        return customHallSessionMapper.getShowDates(movieid);
    }

    @Override
    public HallSessionResResource getById(long id) {
        return customHallSessionMapper.selectByPrimaryKey(id);
    }
}
