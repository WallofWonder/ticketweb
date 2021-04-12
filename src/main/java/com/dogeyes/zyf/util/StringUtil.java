package com.dogeyes.zyf.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    /**
     * 返回字符串冒号后面的子串
     *
     * @param str 字符串
     * @return 冒号后面的子串
     */
    public static String colon(String str) {
        return str.substring(str.indexOf('：') + 1);
    }

    /**
     * 解析字符串中的数字
     * @param str 字符串
     * @return 字符串中的数字
     */
    public static Integer getInt(String str) {
        Pattern pattern = Pattern.compile("[^0-9]");
        Matcher matcher = pattern.matcher(str);
        return Integer.parseInt(matcher.replaceAll("").trim());
    }
}
