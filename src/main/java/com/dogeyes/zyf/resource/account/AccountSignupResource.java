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

    @NotEmpty
    private String mobile;

    @NotEmpty
    @Size(min = 8, max = 20)
    private String pwd;

    @NotEmpty
    private String nickname;

    private Integer sex;
}
