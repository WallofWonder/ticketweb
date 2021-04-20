package com.dogeyes.zyf.config;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */
@Configuration
public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000117627293";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCdDbkTFkk52opVYFmqcuUaEWxuhIxrvziKxaHDrNZIg+bQSUjCA+1NTddJCIxGguNyxDoVTOdUkFy9hVVVbIH1DHAWBG7JQcYo6tvyfLu9zHztWyrjo1Necy+JOLRjLThW9fiBfNAwAXl/aK7BQ+Dh/IzWwznWrToHS1yZ0059z4NMOveXzvASKqKSTypWVrBnseI5nYbWi1yuAPWFTui+s19N+l5QgTSzCRIFJ+GoGlwlGBnFVY4AOpBAuTFLrpePUGu9bwW08cX9ysoNQj9Aa+l6p+HdzvMtoi7dB6hFsyf1IxP3EEOy1LHBnG4YilwoXuqv1czmYmBif3npuRZ/AgMBAAECggEASyWLzqQ1OWdmFV/ax4HeOVDo7yChB9UhOtVBh50lkuD6CeNm2t6CJyD9x8Y9SGfMaNeXayW28nF4zn4DzLH0pMnkv8QzNj0wkdd+klI4iqJTjEa5CN7XPzQiJKhrN6ElegaLd3m/K5kpB1uRcowGCFuNEB2tiRit0Vuv3TKMNgnalQ1d74sGkoF8+XuuCSsBEeIaU5MTjLM+Z01h9L6ZcmtrDChvzGvxSlVpKnpVOH/PnbDlmJ8mlKotqCOVwBGQBjNckXp9HonO1SPB36kxlbSeb3Ft4gKlbbwnF98neAk1fFoV8HOge4gtfVWgoKPF1Gp31RdhaMqShMxKu+Le0QKBgQDR5HxOXn9ZRDCCvWRnw9IwwXXVF8i+lBvD1qJ8m9pqsgQXBwGSj9bjBnxdcNOC/klyUYMcuNSfFUisxzSHUkA0Di1qeaxBnCJvCgiW6w1Km74S2gHJXg4wikO/ccXwolNfz2lQWlWjwCcVjdoFJo+cS0ql4zUtbzJgMIQ4XkB33QKBgQC/jcnWXLexVznjQ8rPmEXQrQRr6pVjsyeucC42zPFMfK9NkiHDG7nuOHRyWw55Uckj+Rk7NjsXJoBs93FREtOBLG8u4IeOrli5mHuO8sQ8ei09xK9ThxzFUBGsLHV2/NPPOIWtQWE5RU5+ZFuDjpcdYunyFmKwN1z4956/cfywCwKBgCxWa7vSUmx07xpvD4qr3vbVpyKAh7NabhMMf/56ncT0HdEPddGT+Py0HglPEB8XwEQZ2+xxTtjcEiINYpdDVLSqWgWn9i9V4CA8qlvXA1PDWn949e+noq+2RWFnkzylzZ7rnX+P1Y9lw9vVvzxfTO7jKL2qJU2Xs7iGBygxIMUxAoGBAKsKmVpeqeuhXmAvDW52oohlpZgS/FftBha9tpZaQ3AvuXzDaoBERq6PHHNsGS19OOR1LfFwSC0wxOYHwNhKvi8OlSy/cmuWBEWdAV8wKMdztOf9sywbbjZFe7JIdI7NzPewmbSNt5mi6Cb1x71d2lN0Gj9/e5mrpcntmYOK7b3nAoGASf3kCxAH+PLQC5uQ/C8iRl3KqW2MLUo9u/yqmMG6Y2VL0bQYFx8WRBjiA8PHZDX/8fattO7+fG0GVBUnOpxy/NXCdyljQPitJbz4Pdl33S9hp4AdQ3VM1yG8TVxBZrhHbvxt4GRMdDkJ+dUOYHYAwAE4zhYcVHiHpBK391LE07Q=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2Ey/iU0i3UkdqKw0bgvI3OvOtJtU2yyEJGfnygOHalvxjRci+p72tu13j+775njdW1zH1A08FBuq7xatuUAi6BruedfciG68awts1SuoguZd2pi4KgFHnjptO0iq362JTVY8blEijcOagJAKe+Y2y/kG+hCbmU50zAm34tcXyqPvYdK1jtJkkbEHqbPgIgbFb0/RV3Gy408mXTRDbFBl5Z3FXa2STV5XAwOVv1enZ95IQNcb/B4njzdfe+F+/Ol4KRyTgpxKbN2IEVkfMLrRIynX24skL21+EeHf/cdapv065HujX2mmuQ854odUckyM6u31TTPlgs9eztglea2QNwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://zyfnwct.natapp1.cc/call";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://zyfnwct.natapp1.cc/admin/alipay/notify";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 数据格式
    public static String format = "json";

    // 日志路径
    public static String log_path = "D:\\";

    @Bean
    public AlipayClient alipayClient() {
        return new DefaultAlipayClient(
                AlipayConfig.gatewayUrl,
                AlipayConfig.app_id,
                AlipayConfig.merchant_private_key,
                AlipayConfig.format,
                AlipayConfig.charset,
                AlipayConfig.alipay_public_key,
                AlipayConfig.sign_type);
    }


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 验证签名
     *
     * @param request 请求
     * @return 是否正确
     */
    public static boolean checkSign(HttpServletRequest request) {
        Map<String, String[]> requestMap = request.getParameterMap();
        Map<String, String> paramsMap = new HashMap<>();
        requestMap.forEach((key, values) -> {
            String strs = "";
            for (String value : values) {
                strs = strs + value;
            }
            System.out.println(key + "===>" + strs);
            paramsMap.put(key, strs);
        });
        System.out.println();
        //调用SDK验证签名
        try {
            return AlipaySignature.rsaCheckV1(paramsMap, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
        } catch (AlipayApiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("*********************验签失败********************");
            return false;
        }

    }
}

