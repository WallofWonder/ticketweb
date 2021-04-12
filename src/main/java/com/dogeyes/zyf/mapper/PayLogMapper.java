package com.dogeyes.zyf.mapper;

import com.dogeyes.zyf.pojo.PayLog;
import com.dogeyes.zyf.pojo.PayLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayLogMapper {
    long countByExample(PayLogExample example);

    int deleteByExample(PayLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PayLog record);

    int insertSelective(PayLog record);

    List<PayLog> selectByExample(PayLogExample example);

    PayLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PayLog record, @Param("example") PayLogExample example);

    int updateByExample(@Param("record") PayLog record, @Param("example") PayLogExample example);

    int updateByPrimaryKeySelective(PayLog record);

    int updateByPrimaryKey(PayLog record);
}