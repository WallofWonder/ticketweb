package com.dogeyes.zyf.service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.dogeyes.zyf.resource.alipay.AliRefundReq;

/**
 * @author ZYF
 * @create 2021-5-10 14:42
 */
public interface AlipayService {

    /**
     * 退款
     *
     *
     * @param refundReq @return 成功或失败
     * @return
     */
    AlipayTradeRefundResponse refund(AliRefundReq refundReq) throws AlipayApiException;
}
