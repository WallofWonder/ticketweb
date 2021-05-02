package com.dogeyes.zyf.mapper;

import com.dogeyes.zyf.pojo.Oder;
import com.dogeyes.zyf.pojo.OderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OderMapper {
    long countByExample(OderExample example);

    int deleteByExample(OderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Oder record);

    int insertSelective(Oder record);

    List<Oder> selectByExample(OderExample example);

    Oder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Oder record, @Param("example") OderExample example);

    int updateByExample(@Param("record") Oder record, @Param("example") OderExample example);

    int updateByPrimaryKeySelective(Oder record);

    int updateByPrimaryKey(Oder record);
}