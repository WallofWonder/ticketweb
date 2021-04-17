package com.dogeyes.zyf.resource.user;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * 管理员注册实体
 *
 * @author ZYF
 * @create 2021-4-17 19:34
 */
@Data
public class UserSignupResource {

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    @Size(min = 8, max = 20)
    private String pwd;

    @NotEmpty
    private String username;

    private Integer sex;
}
