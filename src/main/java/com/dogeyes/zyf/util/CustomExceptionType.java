package com.dogeyes.zyf.util;

import lombok.Getter;

/**
 * 枚举异常的类型
 *
 * @author ZYF
 * @create 2021-4-13 15:17
 */
@Getter
public enum CustomExceptionType {
    USER_INPUT_ERROR(400, "数据错误！"),
    UNAUTHORIZED(401, "没有权限访问！"),
    NOT_FOUND(404, "资源不存在！"),
    SYSTEM_ERROR(500, "系统出现异常！"),
    OTHER_ERROR(999, "系统出现未知异常！");

    CustomExceptionType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private String desc;//异常类型中文描述

    private int code; //code
}
