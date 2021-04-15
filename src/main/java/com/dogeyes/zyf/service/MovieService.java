package com.dogeyes.zyf.service;

import com.dogeyes.zyf.pojo.Movie;
import com.dogeyes.zyf.resource.MovieInfoResource;

import java.util.List;

/**
 * @author ZYF
 * @create 2021-4-13 14:24
 */
public interface MovieService {

    /**
     * 获取新电影信息
     *
     * @param movieInfos 爬取的新电影信息
     */
    void fetchInfo(List<MovieInfoResource> movieInfos);

    /**
     * 批量更新电影信息
     *
     * @param movies 电影信息
     * @return 更新后的电影信息
     */
    List<Movie> batchMovies(List<Movie> movies);
}
