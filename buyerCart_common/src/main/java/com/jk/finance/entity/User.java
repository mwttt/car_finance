package com.jk.finance.entity;

import java.io.Serializable;

public class User implements Serializable{

    private static final long serialVersionUID = 5404938076696831651L;
    private   String  registerId;
    private   String  registerName;
    private   String  registerPass;

    @Override
    public String toString() {
        return "User{" +
                "registerId='" + registerId + '\'' +
                ", registerName='" + registerName + '\'' +
                ", registerPass='" + registerPass + '\'' +
                '}';
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }

    public void setRegisterPass(String registerPass) {
        this.registerPass = registerPass;
    }

    public String getRegisterId() {
        return registerId;
    }

    public String getRegisterName() {
        return registerName;
    }

    public String getRegisterPass() {
        return registerPass;
    }
}