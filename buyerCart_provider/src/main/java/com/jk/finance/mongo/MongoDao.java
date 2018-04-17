package com.jk.finance.mongo;

import com.jk.finance.entity.LoginUser;

import java.util.Date;
import java.util.Map;

public interface MongoDao {
    Map<String,Map<String,Map<String,Integer>>> queryMapByCookId(String cookieValue);

    void updateMap(Map<String, Map<String, Map<String, Integer>>> maps, String cookieValue, Date date);

    void addMap(Map<String, Map<String, Map<String, Integer>>> maps, String cookieValue, Date date);

    LoginUser queryDB(String registerId);

    void addFirstBuyerCart(String registerId, Map<String, Map<String, Map<String, Integer>>> map);

    void updateLoginMap2(String registerId, Map<String, Map<String, Map<String, Integer>>> loginMap);

    void deleteBuyerCartByCookieId(String cookieValue);
}
