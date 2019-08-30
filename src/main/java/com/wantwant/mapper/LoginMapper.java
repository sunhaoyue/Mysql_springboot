package com.wantwant.mapper;

import com.wantwant.pojo.AntiTest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @program: Sqlserver_springboot
 * @description: 登录映射类
 * @author: Sunhaoyue
 * @create: 2019/06/19 15:50
 */

@Mapper
public interface LoginMapper {
    //用户登录验证
    AntiTest userlogin(@Param("user_name") String username, @Param("password") String password);

    //注册新用户(方式1)
    int adduser(@Param("user_name") String username, @Param("password") String password, @Param("createdate") Date createdate, @Param("computecnt") String computecnt);
}
