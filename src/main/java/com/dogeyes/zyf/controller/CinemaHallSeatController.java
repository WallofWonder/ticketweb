package com.dogeyes.zyf.controller;

import com.dogeyes.zyf.pojo.CinemaHallSeat;
import com.dogeyes.zyf.service.CinemaHallSeatService;
import com.dogeyes.zyf.util.AjaxResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZYF
 * @create 2021-4-30 14:29
 */
@RestController
@RequestMapping("seats")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CinemaHallSeatController {

    @Resource(name = "cinemaHallSeatServiceImpl")
    CinemaHallSeatService service;

    @RequestMapping(value = "listSeats", method = RequestMethod.GET)
    public Object listSeatsBySession(long sessionId) {
        List<CinemaHallSeat> seats = service.listSeatsBySession(sessionId);
        return AjaxResponse.success(seats);
    }
}
