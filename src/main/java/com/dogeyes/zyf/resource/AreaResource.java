package com.dogeyes.zyf.resource;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ZYF
 * @create 2021-3-27 14:53
 */
@Data
public class AreaResource implements Serializable {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Long cityId;

    private String dbname;

    private Long provinceId;
}
