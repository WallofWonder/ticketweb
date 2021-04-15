package com.dogeyes.zyf.controller;

import com.dogeyes.zyf.util.AjaxResponse;
import com.dogeyes.zyf.util.CustomException;
import com.dogeyes.zyf.util.CustomExceptionType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    public @ResponseBody
    Object hello(int ok) {
        if (ok == 0) throw new CustomException(CustomExceptionType.SYSTEM_ERROR);
        return AjaxResponse.success();
    }
}
