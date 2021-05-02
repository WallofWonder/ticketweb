package com.dogeyes.zyf.resource.order;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 座位
 *
 * @author ZYF
 * @create 2021-5-2 20:08
 */
@Data
public class SessionSeatReq {

    private Integer x;

    private Integer y;

    private BigDecimal price;

    private Integer stats;

}
