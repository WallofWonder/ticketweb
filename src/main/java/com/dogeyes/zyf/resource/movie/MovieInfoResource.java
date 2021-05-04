package com.dogeyes.zyf.resource.movie;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 爬取的电影信息实体
 *
 * @author ZYF
 * @create 2021-4-12 19:53
 */
@Data
public class MovieInfoResource {
    private String actor;

    private String area;

    private String directedBy;

    private String lange;

    private String dbName;

    private String picURL;

    private Float rate;

    private Integer endureTime;

    private String tpe;
}
