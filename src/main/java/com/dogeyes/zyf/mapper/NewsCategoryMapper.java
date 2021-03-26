package com.dogeyes.zyf.mapper;

import com.dogeyes.zyf.pojo.NewsCategory;
import com.dogeyes.zyf.pojo.example.NewsCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewsCategoryMapper {
    long countByExample(NewsCategoryExample example);

    int deleteByExample(NewsCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NewsCategory record);

    int insertSelective(NewsCategory record);

    List<NewsCategory> selectByExample(NewsCategoryExample example);

    NewsCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NewsCategory record, @Param("example") NewsCategoryExample example);

    int updateByExample(@Param("record") NewsCategory record, @Param("example") NewsCategoryExample example);

    int updateByPrimaryKeySelective(NewsCategory record);

    int updateByPrimaryKey(NewsCategory record);
}
