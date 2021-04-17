package com.dogeyes.zyf.controller;

import com.dogeyes.zyf.pojo.User;
import com.dogeyes.zyf.service.UserService;
import com.dogeyes.zyf.util.AjaxResponse;
import com.dogeyes.zyf.util.CustomException;
import com.dogeyes.zyf.util.CustomExceptionType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZYF
 * @create 2021-4-17 16:48
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource(name = "userServiceImpl")
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    Object login(String email, String pwd) {
        List<User> users = userService.login(email, pwd);
        if (users == null || users.isEmpty()) throw new CustomException(CustomExceptionType.NOT_FOUND, "用户名或密码错误！");
        return AjaxResponse.success(users.get(0));
    }
}
