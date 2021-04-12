package com.dogeyes.zyf.mapper;

import com.dogeyes.zyf.pojo.Movie;
import com.dogeyes.zyf.pojo.MovieExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MovieMapper {
    long countByExample(MovieExample example);

    int deleteByExample(MovieExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Movie record);

    int insertSelective(Movie record);

    List<Movie> selectByExample(MovieExample example);

    Movie selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Movie record, @Param("example") MovieExample example);

    int updateByExample(@Param("record") Movie record, @Param("example") MovieExample example);

    int updateByPrimaryKeySelective(Movie record);

    int updateByPrimaryKey(Movie record);
}