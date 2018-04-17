package com.jk.finance.service.impl;

import com.jk.finance.mongo.MongoDao;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThread implements  Runnable{


    private  String   key;
    private  Map<String, Map<String, Integer>> loginMap;
    private  Map<String, Integer> stringMap;
    private  String   registerId;
    private  MongoDao mongoDao;

    public MyThread (String key, Map<String, Map<String, Integer>> loginMap, Map<String, Integer> stringMap,
                     String   registerId, MongoDao mongoDao) {


            this.key = key;
            this.loginMap = loginMap;
            this.stringMap = stringMap;
            this.registerId = registerId;
            this.mongoDao = mongoDao;
    }
    @Override
    public void run() {


        //公司ID 相同  循环比较产品名称
            Map<String, Integer> stringIntegerMap = loginMap.get(key);

            ExecutorService executor = Executors.newSingleThreadExecutor();
            for (Map.Entry<String, Integer> next1: stringMap.entrySet()) {

                int a = 0;
                Integer value = 0;
                for (Map.Entry<String, Integer> next: stringIntegerMap.entrySet()) {

                    if (next1.getKey().equals(next.getKey())) { //产品名称相同 改变数量

                       a = 1;
                       value = next.getValue();

                    }
                }
                if (a != 1) {

                    stringIntegerMap.put(next1.getKey(), next1.getValue());
                    loginMap.put(key, stringIntegerMap);
                }
                if (a == 1) {

                    stringIntegerMap.put(next1.getKey(), (value + next1.getValue()));
                    loginMap.put(key, stringIntegerMap);
                }

            }
            Map<String, Map<String, Map<String, Integer>>> mapo = new HashMap<>();
            mapo.put(registerId, loginMap);
            System.out.println("走dao层");
            mongoDao.updateLoginMap2(registerId, mapo);

    }
}