package com.dogeyes.zyf.util;

import com.dogeyes.zyf.resource.PageParamResource;
import com.github.pagehelper.PageHelper;

/**
 * 分页帮助类
 *
 * @author ZYF
 * @create 2021-3-28 13:20
 */
public class PageSortHelper {
    public static void pageAndSort(PageParamResource pageParam, Class<?> sortClass) {
        String orderBy = pageParam.getOrderBy();
        if (!StringUtil.isNullOrWhiteSpace(orderBy)) {
            orderBy = pageParam.getOrderBy().trim();
            String[] strings = orderBy.split("\\s+");
            if (strings.length > 0) {
                if (PropertyMapperUtil.hasProperty(strings[0], sortClass)) {
                    String property = PropertyMapperUtil.getUnderscoreFormat(strings[0]);
                    if (strings.length > 1) {
                        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), property + " " + strings[1]);
                    }
                    else {
                        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), property);
                    }
                    return;
                }
            }
        }
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
    }
}
