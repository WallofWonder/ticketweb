package com.dogeyes.zyf.service;

import com.dogeyes.zyf.pojo.Account;
import com.dogeyes.zyf.resource.account.AccountSignupResource;
import com.dogeyes.zyf.resource.common.PageParamResource;
import com.github.pagehelper.PageInfo;

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

    /**
     * 生成验证码
     *
     * @param email 邮箱
     * @return 验证码
     */
    boolean existsEmail(String email);

    /**
     * 更新账户信息
     *
     * @param account
     * @return 更新后的账户信息
     */
    Account update(Account account);

    /**
     * 账户列表
     * @param page 分页参数
     * @return 账户列表
     */
    PageInfo<Account> listAll(PageParamResource page);
}
