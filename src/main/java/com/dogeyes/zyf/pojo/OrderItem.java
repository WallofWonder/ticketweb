package com.dogeyes.zyf.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderItem implements Serializable {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private BigDecimal money;

    private Long cinemaHallSeatId;

    private Long orderId;

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

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Long getCinemaHallSeatId() {
        return cinemaHallSeatId;
    }

    public void setCinemaHallSeatId(Long cinemaHallSeatId) {
        this.cinemaHallSeatId = cinemaHallSeatId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}