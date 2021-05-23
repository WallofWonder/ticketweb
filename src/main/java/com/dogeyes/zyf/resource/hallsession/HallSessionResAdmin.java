package com.dogeyes.zyf.resource.hallsession;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 场次信息响应体
 *
 * @author ZYF
 * @create 2021-4-19 13:48
 */
@Data
public class HallSessionResAdmin {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private String showDate;

    private String showTime;

    private Long cinemaId;

    private Long cinemaHallId;

    private Long movieId;

    private Integer cinemaSessionType;

    private String endTime;

    private BigDecimal newPrice;

    private BigDecimal oldPrice;

    private String startTime;

    private String cinemaHallName;

    private String lange;

    private String movieName;

    private Integer maxX;

    private Integer maxY;
}
