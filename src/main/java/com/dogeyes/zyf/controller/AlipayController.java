package com.dogeyes.zyf.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.dogeyes.zyf.config.AlipayConfig;
import com.dogeyes.zyf.resource.alipay.AliReturnPay;
import com.dogeyes.zyf.util.AjaxResponse;
import com.dogeyes.zyf.util.MyWebSocket;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ZYF
 * @create 2021-4-20 2:10
 */
@Controller
@Log4j2
public class AlipayController {

    @Autowired
    private MyWebSocket myWebSocket;

    @Autowired
    private AlipayClient alipayClient;

    @RequestMapping("/createQR")
    public @ResponseBody
    Object send() throws AlipayApiException {
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        AlipayTradePrecreateModel model = new AlipayTradePrecreateModel();
        request.setBizModel(model);
        request.setNotifyUrl(AlipayConfig.notify_url);
        model.setOutTradeNo(String.valueOf(System.currentTimeMillis()));
        model.setTotalAmount("88.88");
        model.setSubject("电影票1");
        //return alipayClient.pageExecute(request).getBody();
        AlipayTradePrecreateResponse response = alipayClient.execute(request);
        if (response.isSuccess()) {
            log.info("createQR 调用成功");
            return AjaxResponse.success(response.getQrCode());
        }
        else {
            log.info("createQR 调用失败");
            return "";
        }
    }


    @RequestMapping("/call")
    public void notifyUrl(HttpServletRequest request, HttpServletResponse response, AliReturnPay returnPay) throws IOException {
        response.setContentType("type=text/html;charset=UTF-8");
        log.info("支付宝回调");

        if (!AlipayConfig.checkSign(request)) {
            log.info("验签失败");
            response.getWriter().write("failture");
            return;
        }

        if (returnPay == null) {
            log.info("回调对象为空");
            response.getWriter().write("success");
            return;
        }

        log.info("回调对象：" + returnPay.toString());

        // 支付成功
        if (returnPay.getTrade_status().equals("TRADE_SUCCESS")) {
            myWebSocket.sendMessage("true");
        }
        response.getWriter().write("success");
    }

}
