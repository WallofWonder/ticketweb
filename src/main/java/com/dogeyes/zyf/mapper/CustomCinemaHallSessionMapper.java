package com.dogeyes.zyf.mapper;

import com.dogeyes.zyf.pojo.CinemaHallSession;
import com.dogeyes.zyf.resource.hallsession.HallSessionReqResource;
import com.dogeyes.zyf.resource.hallsession.HallSessionResResource;

import java.util.Date;
import java.util.List;

/**
 * @author ZYF
 * @create 2021-4-19 13:47
 */
public interface CustomCinemaHallSessionMapper {

    List<HallSessionResResource> listShowBy(HallSessionReqResource resource);

    List<String> getShowDates(long movieid);

    HallSessionResResource selectByPrimaryKey(long id);
}
