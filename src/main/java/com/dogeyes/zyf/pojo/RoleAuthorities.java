package com.dogeyes.zyf.pojo;

import java.io.Serializable;

public class RoleAuthorities implements Serializable {
    private Long roleId;

    private Long authoritiesId;

    private static final long serialVersionUID = 1L;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getAuthoritiesId() {
        return authoritiesId;
    }

    public void setAuthoritiesId(Long authoritiesId) {
        this.authoritiesId = authoritiesId;
    }
}