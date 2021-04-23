package com.dogeyes.zyf.jwt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 登录才能进行操作
 *
 * @author ZYF
 * @create 2021-4-23 21:06
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AccountLoginToken {
    boolean required() default true;
}
