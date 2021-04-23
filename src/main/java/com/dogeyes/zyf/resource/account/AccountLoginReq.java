package com.dogeyes.zyf.resource.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZYF
 * @create 2021-4-23 20:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountLoginReq {
    private String mobile;

    private String pwd;
}
