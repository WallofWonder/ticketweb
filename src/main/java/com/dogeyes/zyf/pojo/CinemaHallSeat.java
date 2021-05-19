package com.dogeyes.zyf.pojo;

import java.io.Serializable;
import java.util.Date;

public class CinemaHallSeat implements Serializable {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Integer stats;

    private Integer tpe;

    private Integer x;

    private Integer y;

    private Long hallSessionId;

    private Long oderId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStats() {
        return stats;
    }

    public void setStats(Integer stats) {
        this.stats = stats;
    }

    public Integer getTpe() {
        return tpe;
    }

    public void setTpe(Integer tpe) {
        this.tpe = tpe;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Long getHallSessionId() {
        return hallSessionId;
    }

    public void setHallSessionId(Long hallSessionId) {
        this.hallSessionId = hallSessionId;
    }

    public Long getOderId() {
        return oderId;
    }

    public void setOderId(Long oderId) {
        this.oderId = oderId;
    }
}