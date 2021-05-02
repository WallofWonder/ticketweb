package com.dogeyes.zyf.resource.order;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author ZYF
 * @create 2021-4-20 20:33
 */
@Data
public class OrderReq {
    // 交易号
    private Long id;

    // 价格
    private BigDecimal newMoney;

    private BigDecimal oldMoney;

    private Long accountId;

    private Long cinemaHallSessionId;

    private List<SessionSeatReq> seats;
}
