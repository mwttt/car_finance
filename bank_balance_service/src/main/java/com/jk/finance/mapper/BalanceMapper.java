package com.jk.finance.mapper;

import com.jk.finance.entity.Balance;
import org.apache.ibatis.annotations.*;

public interface BalanceMapper {

    @Update("UPDATE t_balance SET balance =  balance +  #{b.balance} where balanId = #{b.balanId}")
    void updateBalance(@Param("b") Balance balanceBean);
}
