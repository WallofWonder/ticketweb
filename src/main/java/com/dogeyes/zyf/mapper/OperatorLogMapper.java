package com.dogeyes.zyf.mapper;

import com.dogeyes.zyf.pojo.OperatorLog;
import com.dogeyes.zyf.pojo.OperatorLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperatorLogMapper {
    long countByExample(OperatorLogExample example);

    int deleteByExample(OperatorLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OperatorLog record);

    int insertSelective(OperatorLog record);

    List<OperatorLog> selectByExample(OperatorLogExample example);

    OperatorLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OperatorLog record, @Param("example") OperatorLogExample example);

    int updateByExample(@Param("record") OperatorLog record, @Param("example") OperatorLogExample example);

    int updateByPrimaryKeySelective(OperatorLog record);

    int updateByPrimaryKey(OperatorLog record);
}