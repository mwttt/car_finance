package com.jk.finance.entity;

import java.io.Serializable;
import java.math.BigDecimal;


public class Balance implements Serializable {

    private static final long serialVersionUID = 6720429732068226011L;
    private String balanId;
    private String userId;
    private BigDecimal balance;

    public String getBalanId() { return balanId; }

    public void setBalanId(String balanId) { this.balanId = balanId; }

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

    public BigDecimal getBalance() { return balance; }

    public void setBalance(BigDecimal balance) { this.balance = balance; }

    @Override
    public String toString() {
        return "Balance{" +
                "balanId='" + balanId + '\'' +
                ", userId='" + userId + '\'' +
                ", balance=" + balance +
                '}';
    }
}
