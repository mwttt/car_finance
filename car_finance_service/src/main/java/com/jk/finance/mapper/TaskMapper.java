package com.jk.finance.mapper;

import com.jk.finance.entity.Bank;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jk.finance.entity.UserDo;

public interface TaskMapper {

	
/*	@Insert("insert into t_ceshic (userid,username,domainid,filename) values (#{userId},#{userName},#{doMainId},#{fileName})")
	void postTask(@Param("userId") String userId, @Param("userName") String userName, @Param("doMainId") String doMainId,
                  @Param("fileName") String fileName);

	
	@Select("select  filename  from  t_ceshic  where domainid = #{id}")
	String queryPictureByDoNameID(@Param("id") String id);*/

	@Select("select  *  from  t_user  where userName = #{userName}")
	UserDo queryUser(@Param("userName") String  userName);

	@Select("select  *  from  t_banks  where userId = #{userId}")
	Bank queryBankCard(String userId);
}
