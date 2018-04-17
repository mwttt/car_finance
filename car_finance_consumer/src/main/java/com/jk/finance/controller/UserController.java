package com.jk.finance.controller;

import com.alibaba.dubbo.common.json.JSONObject;
import com.alibaba.fastjson.JSON;
import com.jk.finance.entity.Bank;
import com.jk.finance.entity.UserDo;
import com.jk.finance.service.UserService;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import net.sf.json.JSONArray;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;


@RestController
@RequestMapping("app/user")
public class UserController {

    @Resource
    private UserService userService;


    @RequestMapping(value = "auth", method = RequestMethod.POST)
    public String queryUser(@RequestBody String str) {
       UserDo userDo =  (UserDo) net.sf.json.JSONObject.toBean(net.sf.json.JSONObject.fromObject(str),UserDo.class);

        System.out.println(userDo.toString());

        UserDo dbuser = userService.queryUser(userDo.getUserName());

        System.out.println(dbuser);

        System.out.println(dbuser.toString());

        if (dbuser == null) {

            return "99";//用户不存在

        } else {
            String reg = "^\\d{15}$|^\\d{17}[0-9Xx]$";
           // Pattern pattern = Pattern.compile(reg);
            if(dbuser.getUserCardNumber().equals(userDo.getUserCardNumber())&&Pattern.compile(reg).matcher(userDo.getUserCardNumber()).matches()){

                String regs="^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
                if (dbuser.getUserPhone().equals(userDo.getUserPhone())&&Pattern.compile(regs).matcher(userDo.getUserPhone()).matches()){
                    int num=(int)(Math.random()*100);
                    System.out.println(num);

                    if(num>60){

                        return  "00";//代表成功
                    }else{

                        return "01";//照片不匹配
                    }

                }else{

                    return "02";//电话号不正确
                }


            }else {
                return "03";//身份证号不正确


            }

        }

    }


    @RequestMapping(value = "queryBankCard", method = RequestMethod.POST)
    public String queryBankCard(Bank bank){

        System.out.println(bank);

        Bank dbBank=userService.queryBankCard(bank.getUserId());

        System.out.println(dbBank);

        if(dbBank!=null){

            if(dbBank.getUserName().equals(bank.getUserName())){
                if(dbBank.getBankCardNumber().equals(bank.getBankCardNumber())){

                    if(dbBank.getBankPhone().equals(bank.getBankPhone())){

                        if(dbBank.getUserCardNo().equals(bank.getUserCardNo())){


                        }else{

                            return "03";//身份证号错误
                        }

                    }else{

                        return "02";//手机号错误
                    }

                }else{
                    return "04";//银行卡不存在

                }

            }else{
                return "01";//姓名错误

            }



        }

            return "99";//错误



    }



    @RequestMapping(value="sendShortMessage" , method = RequestMethod.POST)
    public void sendShortMessage(String telephone , HttpServletRequest request , HttpServletResponse response){
        System.out.println(telephone);
        int C;
        int A=1000;
        C = A+(int)(Math.random()*8999);
        System.out.println("验证码："+C);


        //创建httpclient对象 HttpClients httpclient的封装工具类
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //创建对应的http请求
        HttpPost httpPost = new HttpPost("https://open.ucpaas.com/ol/sms/sendsms");
        //设置对应的请求参数
        Map map = new HashMap<>();
        map.put("sid","c2e8068b78fff26325273a11341a4007");
        map.put("token","9de6c7e4eb64f5c6b4fc576795489d65");
        map.put("appid","b1600b068c3f4ab4bd35f7cf4a248e44");
        map.put("templateid","308117");
        map.put("param",C);
        map.put("mobile",telephone);
        String json = JSON.toJSONString(map);
        System.out.println(json);
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


