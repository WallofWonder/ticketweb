package com.dogeyes.zyf.mapper;

import com.dogeyes.zyf.pojo.CinemaHall;
import com.dogeyes.zyf.pojo.CinemaHallExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CinemaHallMapper {
    long countByExample(CinemaHallExample example);

    int deleteByExample(CinemaHallExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CinemaHall record);

    int insertSelective(CinemaHall record);

    List<CinemaHall> selectByExample(CinemaHallExample example);

    CinemaHall selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CinemaHall record, @Param("example") CinemaHallExample example);

    int updateByExample(@Param("record") CinemaHall record, @Param("example") CinemaHallExample example);

    int updateByPrimaryKeySelective(CinemaHall record);

    int updateByPrimaryKey(CinemaHall record);
}