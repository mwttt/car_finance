package com.jk.finance.mapper;

import com.jk.finance.entity.User;
import org.apache.ibatis.annotations.Select;

public interface TaskMapper {

    @Select("select * from t_user where userid = #{i}")
    User test(int i);
}
