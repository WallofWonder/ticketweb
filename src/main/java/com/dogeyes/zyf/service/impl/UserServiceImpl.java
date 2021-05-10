package com.dogeyes.zyf.service.impl;

import com.dogeyes.zyf.mapper.UserMapper;
import com.dogeyes.zyf.pojo.User;
import com.dogeyes.zyf.pojo.UserExample;
import com.dogeyes.zyf.resource.user.UserSignupResource;
import com.dogeyes.zyf.resource.user.UserTokenResource;
import com.dogeyes.zyf.service.UserService;
import com.dogeyes.zyf.util.PropertyMapperUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
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

    @Value("${web.upload-path}")
    private String uploadPath;

    @Value("${web.avatar-path}")
    private String avatarPath;

    @Value("${web.default-avatar}")
    private String defaultAvatar;

    @Override
    public UserTokenResource login(String email, String pwd) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(email).andPwdEqualTo(pwd);
        List<User> users = userMapper.selectByExample(example);
        if (users.isEmpty()) return null;
        UserTokenResource resource = new UserTokenResource();
        resource.setToken(users.get(0).getEmail());
        return resource;
    }

    @Override
    public Object signup(UserSignupResource resource) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(resource.getEmail());
        if (!userMapper.selectByExample(example).isEmpty()) {
            return 1;
        }
        User user = PropertyMapperUtil.map(resource, User.class);
        if (user != null) {
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            user.setStats(0);
            user.setHeadPic(uploadPath + avatarPath + defaultAvatar);
            userMapper.insertSelective(user);
            UserExample example1 = new UserExample();
            UserExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andEmailEqualTo(user.getEmail());
            return userMapper.selectByExample(example1).get(0);
        }
        return 0;
    }

    @Override
    public User getInfo(String email) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(email);
        return userMapper.selectByExample(example).get(0);
    }
}
