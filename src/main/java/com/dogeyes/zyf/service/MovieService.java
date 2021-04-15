package com.dogeyes.zyf.service;

import com.dogeyes.zyf.pojo.Movie;
import com.dogeyes.zyf.resource.MovieInfoResource;
import com.dogeyes.zyf.resource.PageParamResource;
import com.github.pagehelper.PageInfo;

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

    /**
     * 后台获取电影列表
     *
     * @param isShow
     * @param page 分页参数
     * @return 电影列表
     */
    PageInfo<List<Movie>> listMovies(int isShow, PageParamResource page);
}
