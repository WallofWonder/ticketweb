package com.dogeyes.zyf.resource.order;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ZYF
 * @create 2021-4-20 20:33
 */
@Data
public class OrderResource {
    // 交易号
    private Long id;

    // 价格
    private BigDecimal newMoney;

    private Integer num;

    private BigDecimal oldMoney;

    private Integer dbStatus;

    private Long accountId;

    private Long cinemaHallSessionId;
}
