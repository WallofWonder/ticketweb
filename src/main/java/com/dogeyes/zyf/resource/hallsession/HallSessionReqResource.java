package com.dogeyes.zyf.resource.hallsession;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 放映场次请求体
 *
 * @author ZYF
 * @create 2021-4-19 10:25
 */
@Data
public class HallSessionReqResource {

    @NotNull
    private long movieid;

    @NotNull
    private long cinemaid;

    @NotEmpty
    private String showdate;
}
