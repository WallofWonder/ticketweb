package com.dogeyes.zyf.resource.common;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 分页参数资源
 *
 * @author ZYF
 * @create 2021-3-27 14:18
 */
@Data
public class PageParamResource implements Serializable {

    @Min(value = 1, message = "每页最少显示1条信息！")
    private int pageSize = 10;

    @Min(value = 1, message = "页码从1开始！")
    private int pageNum = 1;

    @Pattern(regexp = "\\s*\\w+\\s*(\\s[Aa][Ss][Cc]|\\s[Dd][Ee][Ss][Cc])?\\s*", message = "排序规则解析错误！")
    private String orderBy = "id ASC";

}
