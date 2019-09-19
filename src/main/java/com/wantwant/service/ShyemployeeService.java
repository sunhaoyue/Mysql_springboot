package com.wantwant.service;


import com.wantwant.pojo.ShyEmployee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: Mysql_springboot
 * @description: 员工
 * @author: Sunhaoyue
 * @create: 2019/09/17 16:22
 */
public interface ShyemployeeService {

    //获取用户所有
    List<ShyEmployee> selectByPrimaryKey (@Param("id") Integer id);
    int  deleteByPrimaryKey (@Param("id") Integer id);
    List<ShyEmployee> insert (@Param("id") Integer id);
    int insertSelective (@Param("list") List<ShyEmployee> shyEmployeeList);
    int updateByPrimaryKey (@Param("id") Integer id);


}
