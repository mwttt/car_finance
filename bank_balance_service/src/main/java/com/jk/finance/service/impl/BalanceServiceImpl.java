package com.jk.finance.service.impl;

import com.jk.finance.entity.Balance;
import com.jk.finance.mapper.BalanceMapper;
import com.jk.finance.service.BalanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("balanceService")
public class BalanceServiceImpl implements BalanceService {

    @Resource
    private BalanceMapper balanceMapper;

    @Override
    public void updateBalance(Balance balanceBean) {
        balanceMapper.updateBalance(balanceBean);
    }
}
