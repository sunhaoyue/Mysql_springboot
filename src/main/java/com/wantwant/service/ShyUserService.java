package com.wantwant.service;


import com.wantwant.pojo.ShyUser;
import org.apache.ibatis.annotations.Param;
import java.util.List;
/**
 * @program: Mysql_springboot
 * @description: 用户信息管理接口
 * @author: Sunhaoyue
 * @create: 2019/09/06 10:11
 */


public interface ShyUserService {
    //根据 id 得到所有的user数据
    List<ShyUser> selectByPrimaryKey(@Param("id") Long id);
}
