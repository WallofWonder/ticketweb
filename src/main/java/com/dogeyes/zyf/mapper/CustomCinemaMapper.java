package com.dogeyes.zyf.mapper;

import com.dogeyes.zyf.pojo.Cinema;

import java.util.List;

/**
 * @author ZYF
 * @create 2021-4-18 21:42
 */
public interface CustomCinemaMapper {
    List<Cinema> listByMovie(long movieid);
}
