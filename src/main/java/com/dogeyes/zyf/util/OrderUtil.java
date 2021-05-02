package com.dogeyes.zyf.util;

/**
 * @author ZYF
 * @create 2021-5-2 21:33
 */
public class OrderUtil {
    public static Long generateOrderId(Long accountId, Long cinemaHallSessionId) {
        String timeMil = String.valueOf(System.currentTimeMillis());
        String accId = String.valueOf(accountId);
        String sessId = String.valueOf(cinemaHallSessionId);

        String genId = accId + sessId + timeMil;

        return Long.parseLong(genId);
    }
}
