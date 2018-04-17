package com.jk.finance.service.impl;

import com.jk.finance.entity.User;
import com.jk.finance.mapper.TaskMapper;
import com.jk.finance.mongo.MongoDao;
import com.jk.finance.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

        @Resource
        private TaskMapper  taskMapper;

        @Resource
        private MongoDao mongoDao;

        @Override
        public User test(String 消费者) {

                System.out.println("消费者");
                User user =  taskMapper.test(1);
                return user;
        }
}