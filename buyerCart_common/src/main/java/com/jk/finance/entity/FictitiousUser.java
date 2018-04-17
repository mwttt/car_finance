package com.jk.finance.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

//虚拟用户表
public class FictitiousUser implements Serializable{

    private static final long serialVersionUID = -6405076525247167538L;
    private  String  _id;
    private  String  cookieId;
    private  Map<String, Map<String, Map<String, Integer>>>  goodsMap;
    private  Date    cookTime;

    public String get_id() {
        return _id;
    }

    public String getCookId() {
        return cookieId;
    }

    public Map<String, Map<String, Map<String, Integer>>> getGoodsMap() {
        return goodsMap;
    }

    public void setGoodsMap(Map<String, Map<String, Map<String, Integer>>> goodsMap) {
        this.goodsMap = goodsMap;
    }

    public Date getCookTime() {
        return cookTime;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setCookId(String cookId) {
        this.cookieId = cookId;
    }



    public void setCookTime(Date cookTime) {
        this.cookTime = cookTime;
    }

    @Override
    public String toString() {
        return "fictitiousUser{" +
                "_id='" + _id + '\'' +
                ", cookieId='" + cookieId + '\'' +
                ", goodsMap='" + goodsMap + '\'' +
                ", cookTime=" + cookTime +
                '}';
    }
}