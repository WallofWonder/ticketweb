package com.dogeyes.zyf.resource.account;

import lombok.Data;

@Data
public class AccountModiPwdReq {

    private String oldPwd;

    private String newPwd;
}
