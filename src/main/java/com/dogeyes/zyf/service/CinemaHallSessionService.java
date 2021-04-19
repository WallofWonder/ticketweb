package com.dogeyes.zyf.service;

import com.dogeyes.zyf.pojo.CinemaHallSession;
import com.dogeyes.zyf.resource.hallsession.HallSessionReqResource;

import java.util.List;

/**
 * @author ZYF
 * @create 2021-4-19 10:08
 */
public interface CinemaHallSessionService {

    /**
     * 根据影院+电影列出放映的场次
     *
     * @param resource 请求体
     * @return 场次列表
     */
    List<CinemaHallSession> listShowBy(HallSessionReqResource resource);
}
