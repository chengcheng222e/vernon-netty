package com.vernon.netty.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: chenyuan
 * Date: 13-11-21
 * Time: PM4:44
 * To change this template use File | Settings | File Templates.
 */
public class UserLogin {

    // ------------------------------------ filed names ------------------------------------
    private Integer userId;
    private String account;
    private Integer status;

    // --------------------------------- setter / getter methods ---------------------------
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "account='" + account + '\'' +
                ", userId=" + userId +
                ", status=" + status +
                '}';
    }
}
