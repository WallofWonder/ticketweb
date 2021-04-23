package com.dogeyes.zyf.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.dogeyes.zyf.pojo.Account;
import com.dogeyes.zyf.pojo.User;

/**
 * JWT 工具类
 *
 * @author ZYF
 * @create 2021-4-23 21:16
 */
public class JwtUtil {

    /**
     * 生成token
     *
     * @param account 用户信息
     * @return token
     */
    public static String getToken(Account account) {
        return JWT.create().withAudience(account.getId().toString())
                .sign(Algorithm.HMAC256(account.getPwd()));
    }
}
