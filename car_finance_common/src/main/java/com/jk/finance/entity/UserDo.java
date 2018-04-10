package com.jk.finance.entity;

import java.io.Serializable;

public class UserDo implements Serializable{


    private static final long serialVersionUID = -4642616801097397303L;
    private  Integer  userId;
        private  String   userName;
        private  String   userPass;

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public void setUserPass(String userPass) {
            this.userPass = userPass;
        }

         public Integer getUserId() {
            return userId;
        }

        public String getUserName() {
            return userName;
        }

        public String getUserPass() {
            return userPass;
        }

    @Override
    public String toString() {
        return "UserDo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                '}';
    }
}