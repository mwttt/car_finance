package com.jk.finance.entity;

import java.io.Serializable;

public class TUser implements Serializable {
    private static final long serialVersionUID = -7845370700971926936L;

    //用户id
    private String userId;
    //账户id
    private String registerId;
    //真是姓名
    private String userName;
    //用户手机号
    private String userPhone;
    //身份证号
    private String userCardNumber;

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

    public String getRegisterId() { return registerId; }

    public void setRegisterId(String registerId) { this.registerId = registerId; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getUserPhone() { return userPhone; }

    public void setUserPhone(String userPhone) { this.userPhone = userPhone; }

    public String getUserCardNumber() { return userCardNumber; }

    public void setUserCardNumber(String userCardNumber) { this.userCardNumber = userCardNumber; }

    @Override
    public String toString() {
        return "TUser{" +
                "userId='" + userId + '\'' +
                ", registerId='" + registerId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userCardNumber='" + userCardNumber + '\'' +
                '}';
    }

}
