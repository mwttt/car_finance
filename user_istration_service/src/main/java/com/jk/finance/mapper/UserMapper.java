package com.jk.finance.mapper;

import com.jk.finance.entity.Integral;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface UserMapper {


    @Update("UPDATE t_integral SET lastYearIntegral = 0 WHERE userId = #{userId}")
    void getIntegralChange(String userId);

    @Select("SELECT * FROM t_integral WHERE userId = #{userId}")
    List<Integral> getIntegralList(String userId);

    @Update("UPDATE t_integral SET userVip = #{i.userVip} where userId = #{userId}")
    void updateIntegral(@Param("i") Integral ial, @Param("userId") String userId);

    @Update(" UPDATE t_integral SET lastYearIntegral = #{integral} , newYearIntegral = 0 where userId = #{userId}")
    void updateIntegralByUserId(@Param("integral") int integral, @Param("userId") String userId);

}
