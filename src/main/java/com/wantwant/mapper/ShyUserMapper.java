package com.wantwant.mapper;

import com.wantwant.pojo.ShyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;



@Mapper
public interface ShyUserMapper {


    //用户登录验证
    ShyUser userlogin(@Param("user_name") String username, @Param("user_password") String password);

    int deleteByPrimaryKey(Long userId);

    int insert(ShyUser record);

    int insertSelective(ShyUser record);

    ShyUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(ShyUser record);

    int updateByPrimaryKey(ShyUser record);
}