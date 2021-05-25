package com.dogeyes.zyf.controller;

import com.dogeyes.zyf.component.FileHandler;
import com.dogeyes.zyf.jwt.AccountLoginToken;
import com.dogeyes.zyf.jwt.CurrentAccount;
import com.dogeyes.zyf.jwt.PassToken;
import com.dogeyes.zyf.pojo.Account;
import com.dogeyes.zyf.resource.account.AccountInfoResp;
import com.dogeyes.zyf.resource.account.AccountLoginReq;
import com.dogeyes.zyf.resource.account.AccountModiPwdReq;
import com.dogeyes.zyf.resource.account.AccountSignupResource;
import com.dogeyes.zyf.resource.common.PageParamResource;
import com.dogeyes.zyf.service.AccountService;
import com.dogeyes.zyf.service.MailService;
import com.dogeyes.zyf.util.AjaxResponse;
import com.dogeyes.zyf.util.CustomException;
import com.dogeyes.zyf.util.CustomExceptionType;
import com.dogeyes.zyf.util.JwtUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author ZYF
 * @create 2021-4-17 19:12
 */
@RestController
@RequestMapping("account")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AccountController {

    @Resource(name = "accountServiceImpl")
    AccountService accountService;

    @Resource
    FileHandler fileHandler;

    @Resource
    MailService mailService;

    @PassToken
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    Object login(@RequestBody AccountLoginReq loginReq) {
        List<Account> accounts = accountService.login(loginReq.getEmail(), loginReq.getPwd());
        if (accounts == null || accounts.isEmpty())
            throw new CustomException(CustomExceptionType.UNAUTHORIZED, "用户名或密码错误！");
        if (accounts.get(0).getStats() == 1) {
            throw new CustomException(CustomExceptionType.UNAUTHORIZED, "账户被冻结！");
        }
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
            Account account = (Account) result;
            AccountInfoResp infoResp = new AccountInfoResp();
            infoResp.setAccount(account);
            infoResp.setToken(JwtUtil.getToken(infoResp.getAccount()));
            return AjaxResponse.success(infoResp);
        }
        int errType = (Integer) result;
        if (errType == 1) throw new CustomException(CustomExceptionType.USER_INPUT_ERROR, "该邮箱已被注册");
        throw new CustomException(CustomExceptionType.SYSTEM_ERROR);
    }

    @PassToken
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody
    Object update(@RequestBody Account account) {
        Account newInfo = accountService.update(account);
        if (newInfo == null) throw new CustomException(CustomExceptionType.SYSTEM_ERROR, "更新失败：服务器内部错误！");
        return AjaxResponse.success(newInfo);
    }

    @PassToken
    @RequestMapping(value = "/avatar", method = RequestMethod.POST)
    public @ResponseBody
    Object avatar(@RequestParam("file") MultipartFile avatar) {
        String path = fileHandler.upload(avatar);
        if (path == null) return AjaxResponse.error(CustomExceptionType.SYSTEM_ERROR, "上传失败");
        return AjaxResponse.success(path, "上传成功");
    }

    @AccountLoginToken
    @RequestMapping(value = "/curInfo", method = RequestMethod.GET)
    public @ResponseBody
    Object getAccountInfo(@CurrentAccount Account account) {
        return AjaxResponse.success(account);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public @ResponseBody
    Object logout() {
        return AjaxResponse.success();
    }

    @PassToken
    @RequestMapping(value = "/sendSignCode", method = RequestMethod.POST)
    public @ResponseBody
    Object sendSignCode(String email) {
        if (accountService.existsEmail(email))
            throw new CustomException(CustomExceptionType.USER_INPUT_ERROR, "该邮箱已被注册");
        return AjaxResponse.success(mailService.sendValidCode(email));
    }

    @PassToken
    @RequestMapping(value = "/sendForgetCode", method = RequestMethod.POST)
    public @ResponseBody
    Object sendForgetCode(String email) {
        if (!accountService.existsEmail(email))
            throw new CustomException(CustomExceptionType.USER_INPUT_ERROR, "该邮箱未注册");
        return AjaxResponse.success(mailService.sendValidCode(email));
    }

    @PassToken
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody Object listAll(@Valid PageParamResource page) {
        return accountService.listAll(page);
    }

    @AccountLoginToken
    @RequestMapping(value = "/modiPwd", method = RequestMethod.POST)
    public @ResponseBody
    Object modiPwd(@RequestBody AccountModiPwdReq req, @CurrentAccount Account account) {
        if (!account.getPwd().equals(req.getOldPwd())) {
            return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR,"原密码错误");
        }
        if (req.getOldPwd().equals(req.getNewPwd())) {
            return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR,"新密码不能和旧密码一致");
        }
        String oldPwd = account.getPwd();
        account.setPwd(req.getNewPwd());
        int result = accountService.updatePwd(account);
        if (result == 0) {
            account.setPwd(oldPwd);
            return AjaxResponse.error(CustomExceptionType.NOT_FOUND,"未找到该用户");
        }
        return AjaxResponse.success(JwtUtil.getToken(account),"密码修改成功");
    }

    @PassToken
    @RequestMapping(value = "/forgetPwd", method = RequestMethod.POST)
    public @ResponseBody
    Object forgetPwd(String email, String newPwd) {
        int result = accountService.forgetPwd(email, newPwd);
        if (result == -1) {
            return AjaxResponse.error(CustomExceptionType.NOT_FOUND, "该邮箱未注册");
        }
        if (result == 0) {
            return AjaxResponse.error(CustomExceptionType.SYSTEM_ERROR, "密码修改失败");
        }
        return AjaxResponse.success(null, "密码修改成功");
    }
}
