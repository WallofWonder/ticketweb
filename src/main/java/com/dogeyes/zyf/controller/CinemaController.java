package com.dogeyes.zyf.controller;

import com.dogeyes.zyf.pojo.Cinema;
import com.dogeyes.zyf.resource.movie.MovieInfoResource;
import com.dogeyes.zyf.service.CinemaService;
import com.dogeyes.zyf.util.AjaxResponse;
import com.dogeyes.zyf.util.CustomException;
import com.dogeyes.zyf.util.CustomExceptionType;
import com.dogeyes.zyf.util.DataSpider;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @author ZYF
 * @create 2021-4-17 0:45
 */
@RestController
@RequestMapping("admin/cinemas")
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
}
