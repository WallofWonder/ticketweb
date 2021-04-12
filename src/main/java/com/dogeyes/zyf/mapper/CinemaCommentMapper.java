package com.dogeyes.zyf.mapper;

import com.dogeyes.zyf.pojo.CinemaComment;
import com.dogeyes.zyf.pojo.CinemaCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CinemaCommentMapper {
    long countByExample(CinemaCommentExample example);

    int deleteByExample(CinemaCommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CinemaComment record);

    int insertSelective(CinemaComment record);

    List<CinemaComment> selectByExample(CinemaCommentExample example);

    CinemaComment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CinemaComment record, @Param("example") CinemaCommentExample example);

    int updateByExample(@Param("record") CinemaComment record, @Param("example") CinemaCommentExample example);

    int updateByPrimaryKeySelective(CinemaComment record);

    int updateByPrimaryKey(CinemaComment record);
}