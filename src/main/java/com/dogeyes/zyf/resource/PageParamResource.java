package com.dogeyes.zyf.resource;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页参数资源
 *
 * @author ZYF
 * @create 2021-3-27 14:18
 */
@Data
public class PageParamResource implements Serializable {

    private int pageSize = 10;

    private int pageNum = 1;

    private String orderBy;

}
