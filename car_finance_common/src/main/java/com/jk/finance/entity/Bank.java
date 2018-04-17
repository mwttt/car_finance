package com.jk.finance.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/12.
 */
public class Bank implements Serializable {


    private static final long serialVersionUID = -205134027360179718L;
    private String bid;

    private String userId;

    private String bankCardNumber;

    private String bankPhone;

    private String userName;

    private String userCardNo;

    public String getUserCardNo() {
        return userCardNo;
    }

    public void setUserCardNo(String userCardNo) {
        this.userCardNo = userCardNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    public String getBankPhone() {
        return bankPhone;
    }

    public void setBankPhone(String bankPhone) {
        this.bankPhone = bankPhone;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bid='" + bid + '\'' +
                ", userId='" + userId + '\'' +
                ", bankCardNumber='" + bankCardNumber + '\'' +
                ", bankPhone='" + bankPhone + '\'' +
                ", userName='" + userName + '\'' +
                ", userCardNo='" + userCardNo + '\'' +
                '}';
    }
}
