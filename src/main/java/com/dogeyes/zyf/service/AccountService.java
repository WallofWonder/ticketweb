package com.dogeyes.zyf.service;

import com.dogeyes.zyf.pojo.Account;

import java.util.List;

/**
 * @author ZYF
 * @create 2021-4-17 19:14
 */
public interface AccountService {

    /**
     * 登录
     *
     * @param mobile 手机号
     * @param pwd 密码
     * @return 账户信息
     */
    List<Account> login(String mobile, String pwd);
}
