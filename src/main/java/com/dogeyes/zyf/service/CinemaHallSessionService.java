package com.dogeyes.zyf.service;

import com.dogeyes.zyf.resource.common.PageParamResource;
import com.dogeyes.zyf.resource.hallsession.HallSessionReqAdmin;
import com.dogeyes.zyf.resource.hallsession.HallSessionReqResource;
import com.dogeyes.zyf.resource.hallsession.HallSessionResResource;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author ZYF
 * @create 2021-4-19 10:08
 */
public interface CinemaHallSessionService {

    /**
     * 根据影院+电影+时间 列出放映的场次
     *
     * @param resource 请求体
     * @return 场次列表
     */
    List<HallSessionResResource> listShowBy(HallSessionReqResource resource);

    /**
     * 根据影院+电影+时间 列出放映的场次（管理端）
     *
     * @param resource 请求体
     * @param page
     * @return 场次列表
     */
    PageInfo<List<HallSessionResResource>> listShowAdminBy(HallSessionReqAdmin resource, PageParamResource page);

    /**
     * 根据电影 列出放映的时间
     * @param movieid 电影id
     * @return 放映的时间
     */
    List<String> getShowDates(long movieid);

    /**
     * 根据id获取场次
     *
     * @param id 场次id
     * @return 场次
     */
    HallSessionResResource getById(long id);

    /**
     * 根据影院获取放映日期
     *
     * @param cinemaid 影院id
     * @return 放映日期列表
     */
    List<String> getShowDatesAdmin(long cinemaid);
}
