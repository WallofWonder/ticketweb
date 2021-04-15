package com.dogeyes.zyf.component;

import com.dogeyes.zyf.util.AjaxResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 让业务状态与HTTP协议Response状态码一致
 *
 * @author ZYF
 * @create 2021-4-15 13:29
 */
@Component
@ControllerAdvice
public class GlobalResponseAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        // 如果响应结果是JSON数据类型
        if (mediaType.equalsTypeAndSubtype(MediaType.APPLICATION_JSON)) {
            if (o instanceof AjaxResponse) {
                AjaxResponse ajaxResponse = (AjaxResponse) o;
                if (ajaxResponse.getCode() != 999) {
                    // 999不是标准的HTTP状态码，特殊处理
                    serverHttpResponse.setStatusCode(HttpStatus.valueOf(ajaxResponse.getCode()));
                }
                return o;
            }
            else {
                // body不是AjaxResponse，就将body封装为AjaxResponse
                serverHttpResponse.setStatusCode(HttpStatus.OK);
                return AjaxResponse.success(o);
            }
        }

        return o;
    }
}
