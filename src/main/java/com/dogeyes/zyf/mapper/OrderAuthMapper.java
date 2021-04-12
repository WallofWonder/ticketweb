package com.dogeyes.zyf.mapper;

import com.dogeyes.zyf.pojo.OrderAuth;
import com.dogeyes.zyf.pojo.OrderAuthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderAuthMapper {
    long countByExample(OrderAuthExample example);

    int deleteByExample(OrderAuthExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderAuth record);

    int insertSelective(OrderAuth record);

    List<OrderAuth> selectByExample(OrderAuthExample example);

    OrderAuth selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderAuth record, @Param("example") OrderAuthExample example);

    int updateByExample(@Param("record") OrderAuth record, @Param("example") OrderAuthExample example);

    int updateByPrimaryKeySelective(OrderAuth record);

    int updateByPrimaryKey(OrderAuth record);
}