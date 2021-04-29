package com.dogeyes.zyf.controller;

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
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public @ResponseBody
    Object getSession(@RequestBody @Valid HallSessionReqResource resource) {
        List<HallSessionResResource> cinemaHallSessions = cinemaHallSessionService.listShowBy(resource);
        return AjaxResponse.success(cinemaHallSessions);
    }

    //列出放映的时间
    @RequestMapping(value = "/showdates", method = RequestMethod.GET)
    public @ResponseBody
    Object getShowDates(long movieid) {
        List<String> showDates = cinemaHallSessionService.getShowDates(movieid);
        return AjaxResponse.success(showDates);
    }
}
