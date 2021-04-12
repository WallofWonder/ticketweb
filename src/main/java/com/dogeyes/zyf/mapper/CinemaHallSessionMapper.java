package com.dogeyes.zyf.mapper;

import com.dogeyes.zyf.pojo.CinemaHallSession;
import com.dogeyes.zyf.pojo.CinemaHallSessionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CinemaHallSessionMapper {
    long countByExample(CinemaHallSessionExample example);

    int deleteByExample(CinemaHallSessionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CinemaHallSession record);

    int insertSelective(CinemaHallSession record);

    List<CinemaHallSession> selectByExample(CinemaHallSessionExample example);

    CinemaHallSession selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CinemaHallSession record, @Param("example") CinemaHallSessionExample example);

    int updateByExample(@Param("record") CinemaHallSession record, @Param("example") CinemaHallSessionExample example);

    int updateByPrimaryKeySelective(CinemaHallSession record);

    int updateByPrimaryKey(CinemaHallSession record);
}