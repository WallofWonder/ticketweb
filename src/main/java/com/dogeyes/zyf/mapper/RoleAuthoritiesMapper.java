package com.dogeyes.zyf.mapper;

import com.dogeyes.zyf.pojo.RoleAuthorities;
import com.dogeyes.zyf.pojo.example.RoleAuthoritiesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleAuthoritiesMapper {
    long countByExample(RoleAuthoritiesExample example);

    int deleteByExample(RoleAuthoritiesExample example);

    int insert(RoleAuthorities record);

    int insertSelective(RoleAuthorities record);

    List<RoleAuthorities> selectByExample(RoleAuthoritiesExample example);

    int updateByExampleSelective(@Param("record") RoleAuthorities record, @Param("example") RoleAuthoritiesExample example);

    int updateByExample(@Param("record") RoleAuthorities record, @Param("example") RoleAuthoritiesExample example);
}
