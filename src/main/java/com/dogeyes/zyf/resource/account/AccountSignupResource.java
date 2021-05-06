package com.dogeyes.zyf.resource.account;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author ZYF
 * @create 2021-4-17 20:34
 */
@Data
public class AccountSignupResource {

    private String email;

    private String pwd;

    private String nickname;
}
