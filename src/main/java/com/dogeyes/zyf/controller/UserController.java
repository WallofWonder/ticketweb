package com.dogeyes.zyf.controller;

import com.dogeyes.zyf.pojo.User;
import com.dogeyes.zyf.resource.user.UserSignupResource;
import com.dogeyes.zyf.resource.user.UserTokenResource;
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
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Resource(name = "userServiceImpl")
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    Object login(String email, String pwd) {
        UserTokenResource login = userService.login(email, pwd);
        if (login == null) throw new CustomException(CustomExceptionType.USER_INPUT_ERROR, "邮箱或密码不正确！");
        return AjaxResponse.success(login);
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


    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public @ResponseBody
    Object getInfo(String email) {
        User user = userService.getInfo(email);
        if (user == null) throw new CustomException(CustomExceptionType.SYSTEM_ERROR);
        return AjaxResponse.success(user);
    }
}
