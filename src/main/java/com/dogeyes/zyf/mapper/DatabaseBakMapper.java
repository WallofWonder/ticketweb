package com.dogeyes.zyf.mapper;

import com.dogeyes.zyf.pojo.DatabaseBak;
import com.dogeyes.zyf.pojo.example.DatabaseBakExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DatabaseBakMapper {
    long countByExample(DatabaseBakExample example);

    int deleteByExample(DatabaseBakExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DatabaseBak record);

    int insertSelective(DatabaseBak record);

    List<DatabaseBak> selectByExample(DatabaseBakExample example);

    DatabaseBak selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DatabaseBak record, @Param("example") DatabaseBakExample example);

    int updateByExample(@Param("record") DatabaseBak record, @Param("example") DatabaseBakExample example);

    int updateByPrimaryKeySelective(DatabaseBak record);

    int updateByPrimaryKey(DatabaseBak record);
}
