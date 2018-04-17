package com.jk.finance.service.impl;

import com.jk.finance.entity.Goods;
import com.jk.finance.entity.LoginUser;
import com.jk.finance.entity.User;
import com.jk.finance.mapper.TaskMapper;
import com.jk.finance.mongo.MongoDao;
import com.jk.finance.service.BuyerCartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service("buyerCartServiceImpl")
public class BuyerCartServiceImpl implements BuyerCartService {

    @Resource
    private TaskMapper  taskMapper;

    @Resource
    private MongoDao  mongoDao;

    private  Map<String, Map<String, Map<String, Integer>>> map;

    @Override
    public User test() {


        return taskMapper.test(1);
    }

    //根据cookie 去库里查询大字段
    @Override
    public Map<String, Map<String, Map<String, Integer>>> queryMapByCookId(String cookieValue) {


        return mongoDao.queryMapByCookId(cookieValue);
    }

    //数据库里有大字段  通过controller修改数据后 到monggodao 修改
    @Override
    public void updateMap(Map<String, Map<String, Map<String, Integer>>> maps, String cookieValue, Date date) {

        mongoDao.updateMap(maps, cookieValue, date);
    }

    //数据里没有相应大字段 直接添加进去
    @Override
    public void addMap(Map<String, Map<String, Map<String, Integer>>> maps, String cookieValue, Date date) {

        mongoDao.addMap(maps, cookieValue, date);
    }

    // 用户已经登录 把maps 再添加到用户在mysql里的购物车
    @Override
    public void loginOperation(String cookieValue, User user, Goods goods, Map<String, Map<String, Map<String, Integer>>> maps) {

        //先查询登录的用户购物车是否为空
        LoginUser loginUser = mongoDao.queryDB(user.getRegisterId());
        if (loginUser != null) {
            System.out.println(loginUser.toString());
        }

        //如果真实购物表里是空的  直接添加
        if (loginUser == null ) { // 1

            System.out.println(user.getRegisterId());
            firstMethod(user.getRegisterId(), goods);
        }
        if (loginUser != null ) {

            secondMethod(user.getRegisterId(), goods, loginUser);
        }

    }

    @Override
    public void fuseBuyerCart(String cookieValue, String userId) {

        LoginUser loginUser = mongoDao.queryDB(userId);
        Map<String, Map<String, Map<String, Integer>>> stringMapMap = mongoDao.queryMapByCookId(cookieValue);
        // 如果都为空  或虚拟购物车里 为空 那就不用管  如果虚拟购物车里有东西 真实购物车里没东西 直接转存 如果俩都
        //有 那么 融合吧
        mongoDao.deleteBuyerCartByCookieId(cookieValue);
        if (stringMapMap != null && loginUser == null) {

            Map<String, Map<String, Integer>> stringMapMap1 = stringMapMap.get(cookieValue);
            Map<String, Map<String, Map<String, Integer>>> mqp = new HashMap<>();
            mqp.put(userId, stringMapMap1);
            mongoDao.addFirstBuyerCart(userId, mqp);
        }
        if (stringMapMap != null && loginUser != null) {

            fourthMethod(stringMapMap, userId, loginUser, cookieValue);

        }
    }

    //4 未登录不为空 登录不为空
    private void fourthMethod(Map<String, Map<String, Map<String, Integer>>> maps, String registerId, LoginUser loginUser, String cookieValue) {


        Map<String, Integer> value ;
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        ExecutorService threadPoo2 = Executors.newSingleThreadExecutor();
        //登录的map
        Map<String, Map<String, Integer>> loginMap = loginUser.getGoodsMap().get(registerId);
        //未登录的map
        Map<String, Map<String, Integer>> stringMapMap = maps.get(cookieValue);

        for (Map.Entry<String, Map<String, Integer>> next1 : stringMapMap.entrySet()) {

            int a = 0;
            for (Map.Entry<String, Map<String, Integer>> next : loginMap.entrySet()) {

                if (next1.getKey().equals(next.getKey())) {

                    a = 1;
                }
            }
            if (a != 1) {

                loginMap.put(next1.getKey(), next1.getValue());
                maps.put(registerId, loginMap);
                mongoDao.updateLoginMap2(registerId, map);
            }
            if (a == 1) {

                threadPool.execute(new MyThread(next1.getKey(), loginMap, next1.getValue(), registerId, mongoDao));
            }
        }
    }


    //3 未登录不为空 登录为空
    private void thirdMethod(Map<String, Map<String, Map<String, Integer>>> maps, String registerId, Goods goods, String cookieValue) {
        //根据cookieValue删除未登录的数据
        System.out.println("第san方法");
        Map<String, Map<String, Integer>> stringMapMap = maps.get(cookieValue);
        testUtil(stringMapMap, goods, registerId);

    }

    private void testUtil(Map<String, Map<String, Integer>> loginMap, Goods goods,  String registerId) {

        int a = 0;
        String gongsiId = "";
        int b = 0;
        String name = "";
        Integer value = 0;
        Iterator<Map.Entry<String, Map<String, Integer>>> iterator = loginMap.entrySet().iterator();
        while (iterator.hasNext()) {

            Map.Entry<String, Map<String, Integer>> next = iterator.next();
            if (next.getKey().equals(goods.getCompanyId())) {

                a = 1;
                gongsiId = goods.getCompanyId();
            }
        }
        if (a != 1) {//没有相同的公司ID 从新put

            Map<String, Integer> map1 = new HashMap<>();
            map1.put(goods.getGoodsName(), goods.getGoodsNum());
            loginMap.put(goods.getCompanyId(), map1);
            System.out.println("zheshi1----"+loginMap);
        }

        if (a == 1) {

            Map<String, Integer> stringIntegerMap = loginMap.get(gongsiId);
            Iterator<Map.Entry<String, Integer>> iterator1 = stringIntegerMap.entrySet().iterator();
            while (iterator1.hasNext()) {

                Map.Entry<String, Integer> next = iterator1.next();
                if (next.getKey().equals(goods.getGoodsName())) {

                    b = 1;
                    name = next.getKey();
                    value = next.getValue();
                }
            }
            if (b != 1) {//没有相同名称的 直接put

                System.out.println("==="+loginMap);

                stringIntegerMap.put(goods.getGoodsName(), goods.getGoodsNum());

                System.out.println("zheshi2----"+loginMap);
            }
            if (b == 1) {

                if (goods.getState() == 1) {


                    stringIntegerMap.put(name, (value+1));

                }
                if (goods.getState() == 2) {


                    stringIntegerMap.put(name, goods.getGoodsNum());

                }
            }
        }
        Map<String, Map<String, Map<String, Integer>>> ma6 = new HashMap<>();
        ma6.put(registerId, loginMap);
        mongoDao.updateLoginMap2(registerId, ma6);
        System.out.println("-------"+loginMap);
        System.out.println("========="+ma6);
    }

    //2 前提是登录状态  真实购物表里不是空的  循环添加
    private void secondMethod(String registerId, Goods goods, LoginUser loginUser) {

        if (loginUser != null) {

            Map<String, Map<String, Integer>> loginMap = loginUser.getGoodsMap().get(registerId);
            testUtil(loginMap, goods, registerId);
        } else {

            HashMap<String, Integer> ashMap = new HashMap<>();
            HashMap<String, Map<String, Integer>> ashMap2 = new HashMap<>();
            Map<String, Map<String, Map<String, Integer>>> maps2 = new HashMap<>();
            ashMap.put(goods.getGoodsName(), goods.getGoodsNum());
            ashMap2.put(goods.getCompanyId(), ashMap);
            maps2.put(registerId, ashMap2);

            mongoDao.addFirstBuyerCart(registerId, maps2);

        }


    }

    //1 前提是登录状态  真实购物表里是空的  直接添加
    private void firstMethod(String registerId, Goods goods) {

        Map<String, Integer> map1 = new HashMap<>();
        map1.put(goods.getGoodsName(), goods.getGoodsNum());
        Map<String, Map<String, Integer>> map2 = new HashMap<>();
        map2.put(goods.getCompanyId(), map1);
        Map<String, Map<String, Map<String, Integer>>> map5 = new HashMap<>();
        map5.put(registerId, map2);
        mongoDao.addFirstBuyerCart(registerId, map5);
        System.out.println("-----------"+map5);
    }


}