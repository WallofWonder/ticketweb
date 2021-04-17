package com.dogeyes.zyf.service;

import com.dogeyes.zyf.pojo.User;
import com.dogeyes.zyf.resource.user.UserSignupResource;
import com.dogeyes.zyf.resource.user.UserTokenResource;

/**
 * @author ZYF
 * @create 2021-4-17 16:50
 */
public interface UserService {

    /**
     * 登录
     *
     * @param email 邮箱
     * @param pwd 密码
     * @return 用户信息
     */
    UserTokenResource login(String email, String pwd);

    /**
     * 注册
     * @param resource 注册信息
     * @return <tt>Integer</tt> - 错误 <br> <tt>User<tt/> - 注册成功后的用户信息
     */
    Object signup(UserSignupResource resource);

    /**
     * 获取用户信息
     *
     * @param email 邮箱
     * @return 用户信息
     */
    User getInfo(String email);
}
