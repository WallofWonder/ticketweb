package com.dogeyes.zyf.service.impl;

import com.dogeyes.zyf.mapper.UserMapper;
import com.dogeyes.zyf.pojo.User;
import com.dogeyes.zyf.pojo.UserExample;
import com.dogeyes.zyf.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZYF
 * @create 2021-4-17 16:51
 */
@Service
@Transactional(rollbackFor = Throwable.class)
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public List<User> login(String email, String pwd) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(email).andPwdEqualTo(pwd);
        return userMapper.selectByExample(example);
    }
}
