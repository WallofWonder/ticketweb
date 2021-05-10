package com.dogeyes.zyf.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.dogeyes.zyf.mapper.OderMapper;
import com.dogeyes.zyf.resource.alipay.AliRefundReq;
import com.dogeyes.zyf.service.AlipayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ZYF
 * @create 2021-5-10 14:45
 */
@Service
public class AlipayServiceImpl implements AlipayService {

    @Autowired
    private AlipayClient alipayClient;

    @Override
    public AlipayTradeRefundResponse refund(AliRefundReq refundReq) throws AlipayApiException {
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        AlipayTradeRefundModel model = new AlipayTradeRefundModel();
        request.setBizModel(model);
        model.setOutTradeNo(refundReq.getOrderId().toString());
        model.setRefundAmount(refundReq.getMoney().toString());

        return alipayClient.execute(request);
    }
}
