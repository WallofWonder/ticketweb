package com.dogeyes.zyf.resource.order;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ZYF
 * @create 2021-5-9 22:22
 */
@Data
public class OrderListRes {
    private Long id;

    private Date createTime;

    private BigDecimal newMoney;

    private String showDate;

    private String startTime;

    private String endTime;

    private String cinemaHallName;

    private String cinemaName;

    private String movieName;

    private Integer dbStats;

    private String nickName;

    private String email;
}
