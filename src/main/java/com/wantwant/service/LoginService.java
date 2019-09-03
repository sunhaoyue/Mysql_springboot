package com.wantwant.service;

import com.wantwant.pojo.ShyUser;

/**
 * @program: Mysql_springboot
 * @description:
 * @author: Sunhaoyue
 * @create: 2019/09/02 15:12
 */


public interface LoginService {
    ShyUser userlogin(String username, String password);
}
