package com.dogeyes.zyf.controller;

import com.dogeyes.zyf.resource.movie.MovieInfoResource;
import com.dogeyes.zyf.resource.movie.MovieUpdateResource;
import com.dogeyes.zyf.resource.common.PageParamResource;
import com.dogeyes.zyf.service.MovieService;
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
 * @create 2021-4-13 14:53
 */
@RestController
@RequestMapping("admin/movies")
public class MovieController {

    @Resource(name = "movieServiceImpl")
    MovieService movieService;

    @PostMapping("/data")
    public @ResponseBody
    Object fetchData() throws IOException {
        List<MovieInfoResource> movieInfos = DataSpider.getMovieInfos();
        movieService.fetchInfo(movieInfos);
        return AjaxResponse.success();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    Object listMovies(@Valid PageParamResource page, String dbname) {
        return movieService.listMovies(dbname, page);
    }


    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public @ResponseBody
    Object getMovie(long id) {
        return movieService.getMovie(id);
    }


    @RequestMapping(value = "update", method = RequestMethod.POST)
    public @ResponseBody
    Object updateMovie(@RequestBody @Valid MovieUpdateResource resource) {
        int result = movieService.updateMovie(resource);
        if (result != 1) throw new CustomException(CustomExceptionType.SYSTEM_ERROR, "更新失败！");
        else return AjaxResponse.success();
    }

    @RequestMapping(value = "/listbycinema",method = RequestMethod.GET)
    public @ResponseBody
    Object listByCinema(long cinemaid) {
        return movieService.listByCinema(cinemaid);
    }
}
