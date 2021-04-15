package com.dogeyes.zyf.service.impl;

import com.dogeyes.zyf.component.FileHandler;
import com.dogeyes.zyf.mapper.CustomMovieMapper;
import com.dogeyes.zyf.mapper.MovieMapper;
import com.dogeyes.zyf.pojo.Movie;
import com.dogeyes.zyf.resource.MovieInfoResource;
import com.dogeyes.zyf.service.MovieService;
import com.dogeyes.zyf.util.PropertyMapperUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ZYF
 * @create 2021-4-13 14:27
 */
@Service
@Transactional(rollbackFor = Throwable.class)
public class MovieServiceImpl implements MovieService {

    @Resource
    MovieMapper movieMapper;

    @Resource
    CustomMovieMapper customMovieMapper;

    @Resource
    FileHandler fileHandler;

    @Override
    public void fetchInfo(List<MovieInfoResource> movieInfos) {
        // todo 爬取逻辑
        List<Movie> movies = new ArrayList<>();
        for (MovieInfoResource info : movieInfos) {
            Movie movie = PropertyMapperUtil.map(info, Movie.class);
            if (movie == null) continue;
            String localPath = fileHandler.toLocalPath(info.getPicURL(), FileHandler.MOVIE_POST);
            movie.setPicture(localPath);
            movie.setIsShow(true);
            movie.setTotalMoney(BigDecimal.ZERO);
            movies.add(movie);
        }
        batchMovies(movies);
    }

    @Override
    public List<Movie> batchMovies(List<Movie> movies) {
        int insertNum = 0;
        for(Movie movie : movies){
            insertNum += customMovieMapper.insert(movie);
        }
        System.out.println("成功存入" + insertNum + "条数据");
        return movies;
    }


}
