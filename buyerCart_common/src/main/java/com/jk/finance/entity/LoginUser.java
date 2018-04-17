package com.jk.finance.entity;

import java.io.Serializable;
import java.util.Map;

public class LoginUser implements Serializable{

    private static final long serialVersionUID = 5472232720908307794L;
    private  String  _id;
        private  String  registerId;
        private  Map<String, Map<String, Map<String, Integer>>>  goodsMap;

    public String get_id() {
        return _id;
    }

    public String getRegisterId() {
        return registerId;
    }

    public Map<String, Map<String, Map<String, Integer>>> getGoodsMap() {
        return goodsMap;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }

    public void setGoodsMap(Map<String, Map<String, Map<String, Integer>>> goodsMap) {
        this.goodsMap = goodsMap;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "_id='" + _id + '\'' +
                ", registerId='" + registerId + '\'' +
                ", goodsMap='" + goodsMap + '\'' +
                '}';
    }
}