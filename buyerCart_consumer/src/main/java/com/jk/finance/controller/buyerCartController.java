package com.jk.finance.controller;

import com.alibaba.fastjson.JSONObject;
import com.jk.finance.entity.Goods;
import com.jk.finance.entity.Goods;
import com.jk.finance.entity.User;
import com.jk.finance.service.BuyerCartService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;


@RestController
@RequestMapping("app/add")
public class buyerCartController {

        @Resource
        private BuyerCartService buyerCartService;

        private  Map<String, Map<String, Map<String, Integer>>> maps;//最里面那层应该是LIST 可以把商品所有信息当一个对象存里面

        private  int a = 0 ;
        private  int b = 0;
        private  String id = "";
        private  String name = "";
        private  Integer value = 0;
        private  Map<String, Integer> stringIntegerMap = new HashMap<>();

        /*
        * 添加商品commodity  如果用户登录了  直接把大字段存musql
        * 如果没登录 取cookie 当虚拟ID  存mongodb
        * 没登录前购物车里有商品  登录后要把购物车里的商品和原来用户购物车里的商品合到一起
        *JSESSIONID  下次做的时候在controller 取出session 和 cookie 在service 判断业务逻辑 优化sql 简洁逻辑
        * 因为 dubbo 消费者到生产者来回要时间 重要的是生产者service 和dao 连着呢  到service 分多个方法去解耦合
        * */
        @RequestMapping(value = "commodity", method = RequestMethod.POST)
        public String test (@RequestBody String str, HttpServletRequest  request){
                //把传过来的 str 解析成对象 或者 字符串


            Goods goods = (Goods)net.sf.json.JSONObject.toBean(net.sf.json.JSONObject.fromObject(str), Goods.class);
            String companyId = goods.getCompanyId();//取出公司ID
            String goodsId = goods.getGoodsId();//商品ID
            String goodsName = goods.getGoodsName();//商品name
            Integer goodsNum = goods.getGoodsNum();//商品数量
            Integer state = goods.getState();//状态
            BigDecimal goodsMoney = goods.getGoodsMoney();//商品价格
            //判断穿过来的参数是否齐全 状态对应的个数是否对
            if (companyId != null && goodsName != null) {

                if (state == 1 && goodsNum ==1) {


                } else if (state == 2){


                } else {

                    return "02";  //02代表状态有问题
                }

            } else {

                return "01"; //01代表参数有问题
            }
            //先判断用户是否登录
                //User user = (User)request.getSession().getAttribute("dbuser");

            User user = new User();
            user.setRegisterId("567");
                //定义一个字符串  把浏览器生成的cookie 放进去
                String  cookieValue = "";
                Cookie[] cookies = request.getCookies();
                for (Cookie cookie: cookies) {

                    if ("JSESSIONID".equals(cookie.getName())) {

                        cookieValue = cookie.getValue();
                    }
                }
               // Map<String, Map<String, List>> map = new HashMap<>();
            // 先从mongo里查询 是否有这个虚拟用户ID  有的话直接取出来 没有创建一个
            maps = buyerCartService.queryMapByCookId(cookieValue);
            
                if (user == null) {

                    //假设 用户往购物车添加商品时要有企业ID 商品 名称  商品价格
                    if (maps != null) { //该虚拟ID 已经往map里存过东西了 直接用
                        //查出来后取出来cookid 主KEY 的value 然后iterator 遍历
                        Map<String, Map<String, Integer>> stringListMap = maps.get(cookieValue);
                        Iterator<Map.Entry<String, Map<String, Integer>>> iterator = stringListMap.entrySet().iterator();
                        while (iterator.hasNext()) {

                            Map.Entry<String, Map<String, Integer>> next = iterator.next();
                            String key = next.getKey();
                            //如果key等于传过来的企业ID 就存这个map里 如果没有就新建一个企业id
                            if (companyId.equals(key)) {

                               a = 1;
                               id = companyId;
                            }
                        }
                            if (a != 1) {

                                //如果没有这个企业的商品就新建一个 企业ID 还有里面的MAP
                                HashMap<String, Integer> hashMap = new HashMap<>();
                                hashMap.put(goodsName, goodsNum);//没有对应的产品  直接添加 数量 默认1
                                stringListMap.put(companyId, hashMap);
                            }
                            if (a == 1) {

                                stringIntegerMap = stringListMap.get(id);
                                Iterator<Map.Entry<String, Integer>> iterator1 = stringIntegerMap.entrySet().iterator();
                                while (iterator1.hasNext()) {

                                    Map.Entry<String, Integer> next = iterator1.next();
                                    if (next.getKey().equals(goodsName)) {

                                        b = 1;
                                        name = next.getKey();
                                        value = next.getValue();
                                    }
                                }
                            }
                            if (b != 1) {

                                stringIntegerMap.put(goodsName, goodsNum);
                            }
                            if (b == 1) {

                                if (state == 1) {

                                    stringIntegerMap.put(name, value+1);
                                }
                                if (state == 2) {

                                    stringIntegerMap.put(name, goodsNum);
                                }
                            }



                        //调用service 把修改好的maps 存到mongodb
                        System.out.println(maps);
                        buyerCartService.updateMap(maps, cookieValue, new Date());

                    } else { //新建cookie 及以下MAP

                        HashMap<String, Integer> ashMap = new HashMap<>();
                        HashMap<String, Map<String, Integer>> ashMap2 = new HashMap<>();
                        Map<String, Map<String, Map<String, Integer>>> maps2 = new HashMap<>();
                        ashMap.put(goodsName, goodsNum);//没有对应的产品  直接添加 数量 默认1
                        ashMap2.put(companyId, ashMap);
                        maps2.put(cookieValue, ashMap2);
                        //调用service 把s添加好的maps 存到mongodb
                        buyerCartService.addMap(maps2, cookieValue, new Date());
                    }


                } else { //如果用户登录了 看这个账号购物车里有东西没有直接存 有的话循环看有没有相同的

                    buyerCartService.loginOperation(cookieValue, user, goods, maps);
                }
            return "00"; //00代表成功
        }

        //get 登录后必须走这个方法  把虚拟购物车融合到真实购物车里
        @RequestMapping(value = "ronghe", method = RequestMethod.GET)
        public  void  ronghe (HttpServletRequest  request) {

            //假设登录的用户ID为123
            String userId = "888";
            String  cookieValue = "";
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie: cookies) {

                if ("JSESSIONID".equals(cookie.getName())) {

                    cookieValue = cookie.getValue();
                }
            }
            //融合购物车
            buyerCartService.fuseBuyerCart(cookieValue, userId);

        }



}