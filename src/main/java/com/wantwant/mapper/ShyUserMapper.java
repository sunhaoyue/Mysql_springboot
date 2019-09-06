package com.wantwant.mapper;

import com.wantwant.pojo.ShyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface ShyUserMapper {


    //用户登录验证
    ShyUser userlogin(@Param("userName") String username, @Param("userPassword") String password);

    List<ShyUser> selectByPrimaryKey(@Param("userId") Long userId);

    int deleteByPrimaryKey(Long userId);

    int insert(ShyUser record);

    int insertSelective(ShyUser record);

    int updateByPrimaryKeySelective(ShyUser record);

    int updateByPrimaryKey(ShyUser record);
}