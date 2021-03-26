package com.dogeyes.zyf.mapper;

import com.dogeyes.zyf.pojo.CinemaHallSeat;
import com.dogeyes.zyf.pojo.example.CinemaHallSeatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CinemaHallSeatMapper {
    long countByExample(CinemaHallSeatExample example);

    int deleteByExample(CinemaHallSeatExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CinemaHallSeat record);

    int insertSelective(CinemaHallSeat record);

    List<CinemaHallSeat> selectByExample(CinemaHallSeatExample example);

    CinemaHallSeat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CinemaHallSeat record, @Param("example") CinemaHallSeatExample example);

    int updateByExample(@Param("record") CinemaHallSeat record, @Param("example") CinemaHallSeatExample example);

    int updateByPrimaryKeySelective(CinemaHallSeat record);

    int updateByPrimaryKey(CinemaHallSeat record);
}
