package com.jk.finance.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/17.
 */
public class User implements Serializable{

    private static final long serialVersionUID = 6518698506326031677L;
    private String userId;

    private String userName;

    private String registerId;

    private String userPhone;

    private String userCardNumber;

    private String userPhoto;



    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
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
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", registerId='" + registerId + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userCardNumber='" + userCardNumber + '\'' +
                ", userPhoto='" + userPhoto + '\'' +
                '}';
    }
}
