package com.dogeyes.zyf.controller;

import com.dogeyes.zyf.jwt.AccountLoginToken;
import com.dogeyes.zyf.util.AjaxResponse;
import com.dogeyes.zyf.util.CustomException;
import com.dogeyes.zyf.util.CustomExceptionType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class HelloController {
    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    public @ResponseBody
    Object hello(int ok) {
        if (ok == 0) throw new CustomException(CustomExceptionType.SYSTEM_ERROR);
        return AjaxResponse.success();
    }

    @AccountLoginToken
    @RequestMapping(value = "/testToken", method = RequestMethod.GET)
    public @ResponseBody
    Object getToken(@RequestHeader("token") String token) {
        return AjaxResponse.success(token);
    }
}
