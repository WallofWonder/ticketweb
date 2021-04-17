package com.dogeyes.zyf.controller;

import com.dogeyes.zyf.pojo.User;
import com.dogeyes.zyf.resource.user.UserSignupResource;
import com.dogeyes.zyf.service.UserService;
import com.dogeyes.zyf.util.AjaxResponse;
import com.dogeyes.zyf.util.CustomException;
import com.dogeyes.zyf.util.CustomExceptionType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
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

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public @ResponseBody
    Object signup(@RequestBody @Valid UserSignupResource resource) {
        Object result = userService.signup(resource);
        if (result instanceof User) {
            return AjaxResponse.success(result);
        }
        int errType = (Integer) result;
        if (errType == 1) throw new CustomException(CustomExceptionType.USER_INPUT_ERROR, "该邮箱已被注册");
        throw new CustomException(CustomExceptionType.SYSTEM_ERROR);
    }

}
