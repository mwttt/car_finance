package com.jk.finance.controller;

import com.jk.finance.entity.Balance;
import com.jk.finance.service.BalanceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
public class BalanceController {

    @Resource
    private BalanceService balanceService;

    @RequestMapping(value = "saveBalance",method = RequestMethod.POST)
    private int saveBalance(BigDecimal balance, String bankCardNumber ){

        String userid = "666";
        System.out.println(balance +",++"+bankCardNumber);
        String balacid = "22";

        Double balance1 = Double.valueOf(balance.doubleValue());
        System.out.println(balance1);
        int msg ;
        if(balance1!=0){
            if(balance1<5000){
                return 1;//充值不得小于5000
            }else{
                if(balance1%5000==0){

                    Balance balanceBean = new Balance();
                    balanceBean.setBalanId(balacid);
                    balanceBean.setUserId(userid);
                    balanceBean.setBalance(balance);
                    balanceService.updateBalance(balanceBean);
                    return 2;//可充值
                }else{
                    return 3;//充值需是5000或是5000的倍数
                }
            }
        }
        return 4;//充值失败
    }
}
