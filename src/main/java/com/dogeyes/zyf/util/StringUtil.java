package com.dogeyes.zyf.util;

/**
 * String检查帮助工具
 *
 * @author ZYF
 * @create 2021-3-28 11:27
 */
public class StringUtil {
    public static boolean isNullOrWhiteSpace(String s) {
        return s == null || s.trim().length() == 0;
    }

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.length() == 0;
    }
}
