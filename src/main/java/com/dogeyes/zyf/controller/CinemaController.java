package com.dogeyes.zyf.controller;

import com.dogeyes.zyf.pojo.Cinema;
import com.dogeyes.zyf.resource.common.PageParamResource;
import com.dogeyes.zyf.service.CinemaService;
import com.dogeyes.zyf.util.AjaxResponse;
import com.dogeyes.zyf.util.CustomException;
import com.dogeyes.zyf.util.CustomExceptionType;
import com.dogeyes.zyf.util.DataSpider;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * @author ZYF
 * @create 2021-4-17 0:45
 */
@RestController
@RequestMapping("admin/cinemas")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CinemaController {

    @Resource(name = "cinemaServiceImpl")
    CinemaService cinemaService;

    @PostMapping("/data")
    public @ResponseBody
    Object fetchData() throws IOException {
        List<Cinema> cinemaInfos = DataSpider.getCinemaInfos();
        cinemaService.fetchInfo(cinemaInfos);
        return AjaxResponse.success();
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public @ResponseBody
    Object getDetails(int id) {
        Cinema cinema = cinemaService.selectCinemaById(id);
        if (cinema == null) throw new CustomException(CustomExceptionType.NOT_FOUND);
        return AjaxResponse.success(cinema);
    }

    @Deprecated
    @RequestMapping(value = "/listbymovie", method = RequestMethod.GET)
    public @ResponseBody
    Object listByMovie(long movieid) {
        List<Cinema> cinemas = cinemaService.listByMovie(movieid);
        return AjaxResponse.success(cinemas);
    }

    @RequestMapping(value = "/listbyarea",method = RequestMethod.GET)
    public @ResponseBody
    Object listByArea(long areaid) {
        List<Cinema> cinemas = cinemaService.listByArea(areaid);
        return AjaxResponse.success(cinemas);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    Object list(@Valid PageParamResource page, String dbName, long areaId) {
        return cinemaService.list(page, dbName, areaId);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody
    Object update(@RequestBody Cinema cinema) {
        System.out.println("?");
        return cinemaService.update(cinema);
    }

}
