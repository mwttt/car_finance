package com.jk.finance.service;

import com.jk.finance.entity.Goods;
import com.jk.finance.entity.User;

import java.util.Date;
import java.util.Map;

public interface BuyerCartService {


    User test();

    Map<String,Map<String,Map<String,Integer>>> queryMapByCookId(String cookieValue);

    void updateMap(Map<String, Map<String, Map<String, Integer>>> maps, String cookieValue, Date date);

    void addMap(Map<String, Map<String, Map<String, Integer>>> maps, String cookieValue, Date date);


    void loginOperation(String cookieValue, User user, Goods goods, Map<String, Map<String, Map<String, Integer>>> maps);

    void fuseBuyerCart(String cookieValue, String userId);
}
