package com.dogeyes.zyf.controller;

import com.dogeyes.zyf.pojo.Cinema;
import com.dogeyes.zyf.resource.movie.MovieInfoResource;
import com.dogeyes.zyf.service.CinemaService;
import com.dogeyes.zyf.util.AjaxResponse;
import com.dogeyes.zyf.util.DataSpider;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
