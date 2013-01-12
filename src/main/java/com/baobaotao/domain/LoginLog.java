package com.baobaotao.domain;

import com.baobaotao.domain.base.BaseDomain;

import java.util.Date;

public class LoginLog extends BaseDomain {

    private int loginLogId;

    private Date loginDate;

    private User user;

    private String ip;

    /**
     * ***********DTO字段********************
     */
    private Date loginDateFrom;
    private Date loginDateTo;

    public int getLoginLogId() {
        return loginLogId;
    }

    public void setLoginLogId(int loginLogId) {
        this.loginLogId = loginLogId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getLoginDateFrom() {
        return loginDateFrom;
    }

    public void setLoginDateFrom(Date loginDateFrom) {
        this.loginDateFrom = loginDateFrom;
    }

    public Date getLoginDateTo() {
        return loginDateTo;
    }

    public void setLoginDateTo(Date loginDateTo) {
        this.loginDateTo = loginDateTo;
    }

}
