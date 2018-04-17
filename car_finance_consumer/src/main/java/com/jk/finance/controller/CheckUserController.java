package com.jk.finance.controller;

import com.alibaba.fastjson.JSON;
import com.jk.finance.entity.User;
import com.jk.finance.entity.UserDo;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/12.
 */
@RestController
@RequestMapping("user")
public class CheckUserController {

    @RequestMapping(value="checkUser" , method = RequestMethod.POST)
    public void checkUser(User user){

        System.out.println(user);

        //创建httpclient对象 HttpClients httpclient的封装工具类
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //创建对应的http请求
        HttpPost httpPost = new HttpPost("http://localhost:8046/app/user/auth");

        //设置对应的请求参数
        Map map = new HashMap<>();
        map.put("type","ID0504");
        map.put("userName",user.getUserName());
        map.put("userCardNumber",user.getUserCardNumber());
        map.put("userPhoto",user.getUserPhoto());
        map.put("transaction","02");
        String json = JSON.toJSONString(map);
        //创建一个string类型的实体
        StringEntity requestEntity = new StringEntity(json, "UTF-8");
        //设置请求类型为json格式
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setEntity(requestEntity);
        try {
            //执行http请求 execute执行CloseableHttpResponse
            CloseableHttpResponse responseNew = httpclient.execute(httpPost);
            //获取响应结果
            HttpEntity entity = responseNew.getEntity();
            //把响应结果转为字符串  EntityUtils entity工具类集合
            String responseStr = EntityUtils.toString(entity);
            System.out.println(responseStr);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }







}
