package com.dogeyes.zyf.controller;

import com.dogeyes.zyf.jwt.AccountLoginToken;
import com.dogeyes.zyf.jwt.CurrentAccount;
import com.dogeyes.zyf.jwt.PassToken;
import com.dogeyes.zyf.pojo.Account;
import com.dogeyes.zyf.resource.account.AccountInfoResp;
import com.dogeyes.zyf.resource.account.AccountLoginReq;
import com.dogeyes.zyf.resource.account.AccountSignupResource;
import com.dogeyes.zyf.service.AccountService;
import com.dogeyes.zyf.util.AjaxResponse;
import com.dogeyes.zyf.util.CustomException;
import com.dogeyes.zyf.util.CustomExceptionType;
import com.dogeyes.zyf.util.JwtUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author ZYF
 * @create 2021-4-17 19:12
 */
@RestController
@RequestMapping("account")
@CrossOrigin(origins = "*",maxAge = 3600)
public class AccountController {

    @Resource(name = "accountServiceImpl")
    AccountService accountService;

    @PassToken
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    Object login(@RequestBody AccountLoginReq loginReq) {
        List<Account> accounts = accountService.login(loginReq.getEmail(), loginReq.getPwd());
        if (accounts == null || accounts.isEmpty())
            throw new CustomException(CustomExceptionType.UNAUTHORIZED, "用户名或密码错误！");
        AccountInfoResp infoResp = new AccountInfoResp();
        infoResp.setAccount(accounts.get(0));
        infoResp.setToken(JwtUtil.getToken(infoResp.getAccount()));
        return AjaxResponse.success(infoResp);
    }

    @PassToken
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public @ResponseBody
    Object signup(@RequestBody @Valid AccountSignupResource resource) {
        Object result = accountService.signup(resource);
        if (result instanceof Account) {
            return AjaxResponse.success(result);
        }
        int errType = (Integer) result;
        if (errType == 1) throw new CustomException(CustomExceptionType.USER_INPUT_ERROR, "该手机号已被注册");
        throw new CustomException(CustomExceptionType.SYSTEM_ERROR);
    }

    @AccountLoginToken
    @RequestMapping(value = "/accountinfo", method = RequestMethod.GET)
    public @ResponseBody
    Object getAccountInfo(@CurrentAccount Account account) {
        return AjaxResponse.success(account);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public @ResponseBody
    Object logout() {
        return AjaxResponse.success();
    }
}
