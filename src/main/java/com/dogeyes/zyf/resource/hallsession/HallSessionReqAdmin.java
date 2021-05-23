package com.dogeyes.zyf.resource.hallsession;

import lombok.Data;

@Data
public class HallSessionReqAdmin {

    private long movieid;

    private long cinemaid;

    private long hallid;

    private String showdate;

}
