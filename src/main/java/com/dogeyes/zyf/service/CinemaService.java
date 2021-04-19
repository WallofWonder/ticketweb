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

    /**
     * 获取指定影院详情
     *
     * @param id 影院id
     * @return 影院详情
     */
    Cinema selectCinemaById(int id);

    /**
     * 根据电影列出放映的影院
     * @param movieid 电影id
     * @return 影院列表
     */
    List<Cinema> listByMovie(long movieid);

    /**
     * 根据地区列出影院
     *
     * @param areaid 地区号
     * @return 影院列表
     */
    List<Cinema> listByArea(Long areaid);
}
