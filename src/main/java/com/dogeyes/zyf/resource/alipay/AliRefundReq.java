package com.dogeyes.zyf.resource.alipay;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author ZYF
 * @create 2021-5-10 14:53
 */
@Data
public class AliRefundReq {

    private Long orderId;

    private BigDecimal money;
}
