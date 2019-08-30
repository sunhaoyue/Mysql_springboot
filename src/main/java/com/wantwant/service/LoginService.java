package com.wantwant.service;

import com.wantwant.pojo.AntiTest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @program: Sqlserver_springboot
 * @description: 登录验证
 * @author: Sunhaoyue
 * @create: 2019/06/19 15:35
 */

@Component
public interface LoginService {
    //用户登录验证
    AntiTest userlogin(@Param("user_name") String username, @Param("password") String password);

    //注册新用户(方式1)
    int adduser(@Param("user_name") String username, @Param("password") String id, @Param("createdate") Date createdate ,@Param("computecnt") String computecnt);
}
