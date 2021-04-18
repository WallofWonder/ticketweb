package com.dogeyes.zyf.service;

import com.dogeyes.zyf.pojo.Movie;
import com.dogeyes.zyf.resource.movie.MovieInfoResource;
import com.dogeyes.zyf.resource.movie.MovieUpdateResource;
import com.dogeyes.zyf.resource.common.PageParamResource;
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
     * @param dbname
     * @param page   分页参数
     * @return 电影列表
     */
    PageInfo<List<Movie>> listMovies(String dbname, PageParamResource page);

    /**
     * 获取电影信息
     *
     * @param id 电影id
     * @return 电影信息
     */
    Movie getMovie(long id);

    /**
     * 更新电影信息
     *
     * @param resource 电影信息
     * @return <tt>1</tt> 更新成功；<tt>-1</tt> 更新失败
     */
    int updateMovie(MovieUpdateResource resource);
}
