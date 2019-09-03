package com.wantwant.service.impl;


import com.wantwant.mapper.ShyUserMapper;
import com.wantwant.pojo.ShyUser;
import com.wantwant.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: Mysql_springboot
 * @description:
 * @author: Sunhaoyue
 * @create: 2019/09/02 15:11
 */


@Service("LoginServiceImpl")
public class LoginServiceImpl implements LoginService {


    @Autowired
    private ShyUserMapper shyUserMapper;

    @Override
    public ShyUser userlogin(String username, String password) {
        return shyUserMapper.userlogin(username,password);
    }

  /*  @Override
    public int adduser(String username, String id, Date createdate, String computecnt) {
        return loginMapper.adduser(username,id,createdate,computecnt);
    }
*/
}