package com.jk.finance.service.impl;


import com.jk.finance.entity.Bank;
import com.jk.finance.entity.UserDo;
import com.jk.finance.mapper.TaskMapper;
import com.jk.finance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
//@Transactional(readOnly=true)//在类上面开启只读事务  因为大部分都是查询
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private TaskMapper  taskMapper;

    @Override
    public UserDo queryUser(String userName) {

        return taskMapper.queryUser(userName);
    }

    @Override
    public Bank queryBankCard(String userId) {


        return taskMapper.queryBankCard(userId);
    }

    /**
     * @Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
     * 在增删改方法上放此注解  表名事务的传播特性required  有异常回滚事务
     * 方法里不能try catch  如果非要抛异常  就把异常 抛到上面
     *
     * startApp 里开启事务管理了
     */
    //@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)


 /*   public UserDo queryUser() {

        System.out.println("到达生产者基地");

        UserDo userDo = taskMapper.queryUser(1);
        return userDo;
    }*/
}