package com.jk.finance.controller;

import com.jk.finance.entity.UserDo;
import com.jk.finance.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("app/user")
public class UserController {

        @Resource
        private UserService userService;

        @RequestMapping("queryUser")
        public  void  Test(){

            UserDo user = userService.queryUser();
            System.out.println(user);
        }

        @RequestMapping("experiment")
        public void  Experiment (HttpServletRequest  request, HttpServletResponse  response) {

            //存cookie  javax
            Cookie cookie = new Cookie("xiaoming"   , "123");
            cookie.setMaxAge(3600*24);  //设置过期时间 单位毫秒
            response.addCookie(cookie);

            //取cookie
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie2: cookies) {

                System.out.println("这是name---"+cookie2.getName());
                System.out.println("这是value--"+cookie2.getValue());
            }

        }

}