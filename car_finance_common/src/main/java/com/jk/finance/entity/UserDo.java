package com.jk.finance.entity;

import java.io.Serializable;

public class UserDo implements Serializable{


    private static final long serialVersionUID = -4642616801097397303L;
        private  String  userId;
        private String registerId;
        private  String   userName;
        private  String   userPhone;
       private  String   userCardNumber;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserCardNumber() {
        return userCardNumber;
    }

    public void setUserCardNumber(String userCardNumber) {
        this.userCardNumber = userCardNumber;
    }

    @Override
    public String toString() {
        return "UserDo{" +
                "userId='" + userId + '\'' +
                ", registerId='" + registerId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userCardNumber='" + userCardNumber + '\'' +
                '}';
    }
}