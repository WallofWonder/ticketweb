package com.dogeyes.zyf.resource;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ZYF
 * @create 2021-4-15 15:06
 */
@Data
public class MovieUpdateResource {
    @NotNull
    private Long id;

    private String actor;

    private String area;

    private String directedBy;

    private String info;

    private String language;

    @NotNull
    @NotEmpty
    private String dbName;

    private String picture;

    @NotNull
    private Float rate;

    private Date showTime;

    private Integer time;

    private String type;

    @NotNull
    private Boolean isShow;
}
