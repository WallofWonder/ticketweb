package com.dogeyes.zyf.resource;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ZYF
 * @create 2021-3-27 14:53
 */
@Data
public class AreaListResource implements Serializable {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Long cityId;

    private String cityName;

    private String dbName;

    private Long provinceId;

    private String provinceName;

    private Boolean isShow;
}
