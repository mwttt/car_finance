package com.jk.finance.service.impl;

import com.jk.finance.entity.Integral;
import com.jk.finance.mapper.UserMapper;
import com.jk.finance.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void getIntegralChange(String userId) {
        userMapper.getIntegralChange(userId);
    }

    @Override
    public List<Integral> getIntegralList(String userId) {
        return userMapper.getIntegralList(userId);
    }

    @Override
    public void updateIntegral(Integral ial, String userId) {
        userMapper.updateIntegral(ial,userId);
    }

    @Override
    public void updateIntegralByUserId(int integral, String userId) {
        userMapper.updateIntegralByUserId(integral,userId);
    }

}
