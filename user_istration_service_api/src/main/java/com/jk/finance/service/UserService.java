package com.jk.finance.service;

import com.jk.finance.entity.Integral;

import java.util.List;

public interface UserService {

    void getIntegralChange(String userId);

    List<Integral> getIntegralList(String userId);

    void updateIntegral(Integral ial, String userId);

    void updateIntegralByUserId(int integral, String userId);

}
