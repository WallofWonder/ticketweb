package com.dogeyes.zyf.service.impl;

import com.dogeyes.zyf.component.FileHandler;
import com.dogeyes.zyf.mapper.CustomMovieMapper;
import com.dogeyes.zyf.mapper.MovieMapper;
import com.dogeyes.zyf.pojo.Movie;
import com.dogeyes.zyf.pojo.MovieExample;
import com.dogeyes.zyf.resource.MovieInfoResource;
import com.dogeyes.zyf.resource.MovieUpdateResource;
import com.dogeyes.zyf.resource.PageParamResource;
import com.dogeyes.zyf.service.MovieService;
import com.dogeyes.zyf.util.PageSortHelper;
import com.dogeyes.zyf.util.PropertyMapperUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
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
        for (Movie movie : movies) {
            insertNum += customMovieMapper.insert(movie);
        }
        System.out.println("成功存入" + insertNum + "条数据");
        return movies;
    }

    @Override
    public PageInfo<List<Movie>> listMovies(int isShow, PageParamResource page) {
        MovieExample example = new MovieExample();
        MovieExample.Criteria criteria = example.createCriteria();
        if (isShow == 1 || isShow == 0) {
            criteria.andIsShowEqualTo(isShow == 1);
        }
        PageSortHelper.pageAndSort(page, Movie.class);
        List<Movie> movies = movieMapper.selectByExample(example);
        return new PageInfo(movies);
    }

    @Override
    public Movie getMovie(long id) {
        return movieMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateMovie(MovieUpdateResource resource) {
        Movie newMovie = PropertyMapperUtil.map(resource, Movie.class);
        movieMapper.updateByPrimaryKeySelective(newMovie);
        return 0;
    }


}
