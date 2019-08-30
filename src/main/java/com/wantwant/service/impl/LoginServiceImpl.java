package com.wantwant.service.impl;

import com.wantwant.mapper.LoginMapper;
import com.wantwant.pojo.AntiTest;
import com.wantwant.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @program: Sqlserver_springboot
 * @description: 登录服务
 * @author: Sunhaoyue
 * @create: 2019/06/19 15:43
 */

@Service("LoginServiceImpl")
public class LoginServiceImpl implements LoginService {


    @Autowired
    private LoginMapper loginMapper;

    @Override
    public AntiTest userlogin(String username, String password) {
        return loginMapper.userlogin(username,password);
    }

    @Override
    public int adduser(String username, String id, Date createdate, String computecnt) {
        return loginMapper.adduser(username,id,createdate,computecnt);
    }

}
