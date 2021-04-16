package com.dogeyes.zyf.service;

import com.dogeyes.zyf.pojo.Cinema;

import java.util.List;

/**
 * @author ZYF
 * @create 2021-4-17 1:27
 */
public interface CinemaService {

    /**
     * 保存爬取的影院信息
     * @param cinemas 影院信息列表
     */
    void fetchInfo(List<Cinema> cinemas);
}
