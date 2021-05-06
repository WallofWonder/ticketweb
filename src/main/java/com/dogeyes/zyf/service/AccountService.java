package com.dogeyes.zyf.service;

import com.dogeyes.zyf.pojo.Account;
import com.dogeyes.zyf.resource.account.AccountSignupResource;

import java.util.List;

/**
 * @author ZYF
 * @create 2021-4-17 19:14
 */
public interface AccountService {

    /**
     * 登录
     *
     * @param email 手机号
     * @param pwd 密码
     * @return 账户信息
     */
    List<Account> login(String email, String pwd);

    /**
     * 注册
     *
     * @param resource 注册信息
     * @return <tt>Integer</tt> - 错误 <br> <tt>User<tt/> - 注册成功后的用户信息
     */
    Object signup(AccountSignupResource resource);

    /**
     * 通过id获取账户
     *
     * @param id id
     * @return 账户信息
     */
    Account findAccountById(Long id);
}
