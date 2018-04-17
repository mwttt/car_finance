package com.jk.finance.service;

import com.jk.finance.entity.Bank;
import com.jk.finance.entity.UserDo;

public interface UserService {

    UserDo queryUser(String userName);

    Bank queryBankCard(String userId);
}
