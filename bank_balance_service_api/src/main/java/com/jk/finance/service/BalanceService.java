package com.jk.finance.service;

import com.jk.finance.entity.Balance;
import org.springframework.stereotype.Service;

@Service
public interface BalanceService {

    void updateBalance(Balance balanceBean);
}
