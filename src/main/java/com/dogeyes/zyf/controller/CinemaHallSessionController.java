package com.dogeyes.zyf.controller;

import com.dogeyes.zyf.resource.common.PageParamResource;
import com.dogeyes.zyf.resource.hallsession.HallSessionReqAdmin;
import com.dogeyes.zyf.resource.hallsession.HallSessionReqResource;
import com.dogeyes.zyf.resource.hallsession.HallSessionResResource;
import com.dogeyes.zyf.service.CinemaHallSessionService;
import com.dogeyes.zyf.util.AjaxResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author ZYF
 * @create 2021-4-19 10:06
 */
@RestController
@RequestMapping("admin/hallsession")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CinemaHallSessionController {
    @Resource(name = "cinemaHallSessionServiceImpl")
    CinemaHallSessionService cinemaHallSessionService;

    // 根据影院+电影+时间列出放映的场次
    @RequestMapping(value = "/show", method = RequestMethod.POST)
    public @ResponseBody
    Object getSession(@RequestBody HallSessionReqResource resource) {
        List<HallSessionResResource> cinemaHallSessions = cinemaHallSessionService.listShowBy(resource);
        return AjaxResponse.success(cinemaHallSessions);
    }

    // 根据影院+电影+时间列出放映的场次
    @RequestMapping(value = "admin/show", method = RequestMethod.POST)
    public @ResponseBody
    Object getSessionAdmin(@RequestBody HallSessionReqAdmin resource, @Valid PageParamResource page) {
        return cinemaHallSessionService.listShowAdminBy(resource, page);
    }

    //列出放映的时间
    @RequestMapping(value = "/showdates", method = RequestMethod.GET)
    public @ResponseBody
    Object getShowDates(long movieid) {
        List<String> showDates = cinemaHallSessionService.getShowDates(movieid);
        return AjaxResponse.success(showDates);
    }

    // 根据影院列出放映时间
    @RequestMapping(value = "admin/showdates", method = RequestMethod.GET)
    public @ResponseBody
    Object getShowDatesByCinema(long cinemaid) {
        List<String> showDates = cinemaHallSessionService.getShowDatesAdmin(cinemaid);
        return AjaxResponse.success(showDates);
    }

    // 场次详情
    @RequestMapping(value = "/getby", method = RequestMethod.GET)
    public @ResponseBody
    Object getById(long id) {
        HallSessionResResource hallSession = cinemaHallSessionService.getById(id);
        return AjaxResponse.success(hallSession);
    }
}
