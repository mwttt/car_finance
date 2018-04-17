package com.jk.finance.entity;

import java.io.Serializable;

public class Bank implements Serializable {
    private static final long serialVersionUID = 9194162860590256859L;

    private String  bankCardId;
    private String cardId;
    private String bankCardTypeId;
    private String bankCardNumber;
    private String bankCardPhone;

    public String getBankCardId() { return bankCardId; }

    public void setBankCardId(String bankCardId) { this.bankCardId = bankCardId; }

    public String getCardId() { return cardId; }

    public void setCardId(String cardId) { this.cardId = cardId; }

    public String getBankCardTypeId() { return bankCardTypeId; }

    public void setBankCardTypeId(String bankCardTypeId) { this.bankCardTypeId = bankCardTypeId; }

    public String getBankCardNumber() { return bankCardNumber; }

    public void setBankCardNumber(String bankCardNumber) { this.bankCardNumber = bankCardNumber; }

    public String getBankCardPhone() { return bankCardPhone; }

    public void setBankCardPhone(String bankCardPhone) { this.bankCardPhone = bankCardPhone; }

    @Override
    public String toString() {
        return "Bank{" +
                "bankCardId='" + bankCardId + '\'' +
                ", cardId='" + cardId + '\'' +
                ", bankCardTypeId='" + bankCardTypeId + '\'' +
                ", bankCardNumber='" + bankCardNumber + '\'' +
                ", bankCardPhone='" + bankCardPhone + '\'' +
                '}';
    }
}
