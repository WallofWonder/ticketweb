package com.dogeyes.zyf.controller;

import com.dogeyes.zyf.pojo.Account;
import com.dogeyes.zyf.service.AccountService;
import com.dogeyes.zyf.util.AjaxResponse;
import com.dogeyes.zyf.util.CustomException;
import com.dogeyes.zyf.util.CustomExceptionType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZYF
 * @create 2021-4-17 19:12
 */
@RestController
@RequestMapping("account")
public class AccountController {

    @Resource(name = "accountServiceImpl")
    AccountService accountService;

    @RequestMapping(value = "/login")
    public @ResponseBody
    Object login(String mobile, String pwd) {
        List<Account> accounts = accountService.login(mobile, pwd);
        if (accounts == null || accounts.isEmpty()) throw new CustomException(CustomExceptionType.NOT_FOUND,"用户名或密码错误！");
        return AjaxResponse.success(accounts.get(0));
    }
}
