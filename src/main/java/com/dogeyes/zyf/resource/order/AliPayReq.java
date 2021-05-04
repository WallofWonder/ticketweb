package com.dogeyes.zyf.resource.order;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author ZYF
 * @create 2021-5-4 21:59
 */
@Data
public class AliPayReq {

    private Long tradeNo;

    private BigDecimal totalAmount;

    private String subject;
}
