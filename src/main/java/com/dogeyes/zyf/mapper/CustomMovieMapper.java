package com.dogeyes.zyf.mapper;

import com.dogeyes.zyf.pojo.Movie;

import java.util.List;

/**
 * @author ZYF
 * @create 2021-4-13 16:41
 */
public interface CustomMovieMapper {
    void batchData(List<Movie> movies);

    /**
     * 自定义添加电影信息
     * 包括添加时间字段和去重
     *
     * @param movie
     * @return
     */
    int insert(Movie movie);

    /**
     * 根据影院列出放映的电影
     * @param cinemaId 影院id
     * @return 电影列表
     */
    List<Movie> listByCinema(long cinemaId);
}
