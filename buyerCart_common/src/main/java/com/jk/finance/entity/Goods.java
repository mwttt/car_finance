package com.jk.finance.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Goods implements Serializable{

    private static final long serialVersionUID = 240485930704525237L;
    //公司ID
        private    String   companyId;
        //商品ID
        private    String   goodsId;
        //商品name
        private    String   goodsName;
        //商品价格
        private    BigDecimal goodsMoney;
        //商品数量
        private    Integer  goodsNum;
        //请求状态
        private    Integer  state;

    @Override
    public String toString() {
        return "CommodityInfo{" +
                "companyId='" + companyId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsMoney=" + goodsMoney +
                ", goodsNum=" + goodsNum +
                ", state=" + state +
                '}';
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public void setGoodsMoney(BigDecimal goodsMoney) {
        this.goodsMoney = goodsMoney;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public BigDecimal getGoodsMoney() {
        return goodsMoney;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public Integer getState() {
        return state;
    }
}