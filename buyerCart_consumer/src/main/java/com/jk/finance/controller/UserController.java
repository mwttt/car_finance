package com.jk.finance.controller;

import com.jk.finance.entity.User;
import com.jk.finance.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("app/user")
public class UserController {

        @Resource
        private UserService  userService;

        /**
         *
         */
        @RequestMapping("test")
        public  void   Test () {

                User user = userService.test("消费者");
                System.out.println(user.toString());
        }
}