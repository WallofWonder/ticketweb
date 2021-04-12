package com.dogeyes.zyf.mapper;

import com.dogeyes.zyf.pojo.MovieComment;
import com.dogeyes.zyf.pojo.MovieCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MovieCommentMapper {
    long countByExample(MovieCommentExample example);

    int deleteByExample(MovieCommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MovieComment record);

    int insertSelective(MovieComment record);

    List<MovieComment> selectByExample(MovieCommentExample example);

    MovieComment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MovieComment record, @Param("example") MovieCommentExample example);

    int updateByExample(@Param("record") MovieComment record, @Param("example") MovieCommentExample example);

    int updateByPrimaryKeySelective(MovieComment record);

    int updateByPrimaryKey(MovieComment record);
}