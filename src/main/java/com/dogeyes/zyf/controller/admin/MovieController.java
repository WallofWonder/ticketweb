package com.dogeyes.zyf.controller.admin;

import com.dogeyes.zyf.resource.MovieInfoResource;
import com.dogeyes.zyf.service.MovieService;
import com.dogeyes.zyf.util.AjaxResponse;
import com.dogeyes.zyf.util.DataSpider;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
}
