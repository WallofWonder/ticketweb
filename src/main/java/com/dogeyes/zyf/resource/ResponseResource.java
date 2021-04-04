package com.dogeyes.zyf.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author ZYF
 * @create 2021-4-4 18:36
 */
@Data
@AllArgsConstructor
public class ResponseResource {
    private Object data;

    @Value("20000")
    private int code;
}
