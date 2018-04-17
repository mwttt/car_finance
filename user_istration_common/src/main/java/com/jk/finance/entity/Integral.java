package com.jk.finance.entity;

import java.io.Serializable;

public class Integral implements Serializable{
    private static final long serialVersionUID = -8346090529726353164L;
    private String integralId;
    private String userId;
    private String userVip;
    private String lastYearIntegral;
    private String newYearIntegral;

    public String getIntegralId() { return integralId; }

    public void setIntegralId(String integralId) { this.integralId = integralId; }

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

    public String getUserVip() { return userVip; }

    public void setUserVip(String userVip) { this.userVip = userVip; }

    public String getLastYearIntegral() { return lastYearIntegral; }

    public void setLastYearIntegral(String lastYearIntegral) { this.lastYearIntegral = lastYearIntegral; }

    public String getNewYearIntegral() { return newYearIntegral; }

    public void setNewYearIntegral(String newYearIntegral) { this.newYearIntegral = newYearIntegral; }

    @Override
    public String toString() {
        return "Integral{" +
                "integralId='" + integralId + '\'' +
                ", userId='" + userId + '\'' +
                ", userVip='" + userVip + '\'' +
                ", lastYearIntegral='" + lastYearIntegral + '\'' +
                ", newYearIntegral='" + newYearIntegral + '\'' +
                '}';
    }
}
