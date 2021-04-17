package com.dogeyes.zyf.service;

import com.dogeyes.zyf.pojo.User;

import java.util.List;

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
    List<User> login(String email, String pwd);
}
