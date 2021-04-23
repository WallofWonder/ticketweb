package com.dogeyes.zyf.resource.account;

import com.dogeyes.zyf.pojo.Account;
import lombok.Data;

/**
 * @author ZYF
 * @create 2021-4-23 21:51
 */
@Data
public class AccountInfoResp {
    private Account account;

    private String token;
}
