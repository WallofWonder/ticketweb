package com.dogeyes.zyf.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Oder implements Serializable {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private BigDecimal newMoney;

    private Integer num;

    private BigDecimal oldMoney;

    private String sn;

    private Integer dbStatus;

    private Long accountId;

    private Long cinemaHallSessionId;

    private String email;

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

    public BigDecimal getNewMoney() {
        return newMoney;
    }

    public void setNewMoney(BigDecimal newMoney) {
        this.newMoney = newMoney;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getOldMoney() {
        return oldMoney;
    }

    public void setOldMoney(BigDecimal oldMoney) {
        this.oldMoney = oldMoney;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer getDbStatus() {
        return dbStatus;
    }

    public void setDbStatus(Integer dbStatus) {
        this.dbStatus = dbStatus;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getCinemaHallSessionId() {
        return cinemaHallSessionId;
    }

    public void setCinemaHallSessionId(Long cinemaHallSessionId) {
        this.cinemaHallSessionId = cinemaHallSessionId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}