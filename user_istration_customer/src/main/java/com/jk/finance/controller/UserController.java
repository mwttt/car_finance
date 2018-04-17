package com.jk.finance.controller;

import com.jk.finance.entity.Integral;
import com.jk.finance.entity.TUser;
import com.jk.finance.service.UserService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @Scheduled(cron = "*/5 * * * * ?")
    @RequestMapping(value = "queryIntegral" )
    public void queryIntegral(){

        String userId = "1";
        //模拟从MongoDB中取出消费金额并计算出今年的消费总额
        Double money = 10000.00;
        //算出今年消费获得的积分
        int integral = (int) Math.floor(money/100);
        //清空去年的积分
        userService.getIntegralChange(userId);
        //查询出该用户信息
        List<Integral> list = userService.getIntegralList(userId);
        /**
         * 可以直接从用户积分中获取今年积分来计算用户的等级，但会存在误差，
         * 所以我选择从MongoDB数据库中获取该用户的消费
         * 总额，然后计算积分
         */
        Integral ial = new Integral();

        if(list.get(0).getUserVip().equals(2)){

            if(integral>=20000){
                ial.setUserVip("3");
                userService.updateIntegral(ial,userId);
            }else if(integral<6000){
                ial.setUserVip("1");
                userService.updateIntegral(ial,userId);
            }
        }

        if(list.get(0).getUserVip().equals(3)){
            if(integral<20000){
                ial.setUserVip("2");
                userService.updateIntegral(ial,userId);
            }
        }
        userService.updateIntegralByUserId(integral,userId);
     }
}
