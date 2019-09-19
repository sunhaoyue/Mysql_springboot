package com.wantwant.service.impl;

import com.github.pagehelper.Page;
import com.wantwant.mapper.ShyEmployeeMapper;
import com.wantwant.pojo.ShyEmployee;
import com.wantwant.service.ShyemployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @program: Mysql_springboot
 * @description: 接口
 * @author: Sunhaoyue
 * @create: 2019/09/17 16:11
 */
@Service("ShyemployeeserviceImpl")
public class ShyemployeeserviceImpl implements ShyemployeeService
{
    @Autowired
    private ShyEmployeeMapper shyEmployeeMapper;

    @Override
    public List<ShyEmployee> selectByPrimaryKey(Integer id) {

        List<ShyEmployee> listEmployee=shyEmployeeMapper.selectByPrimaryKey(id);
        return listEmployee;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public List<ShyEmployee> insert(Integer id) {
        return null;
    }

    @Override
    public int insertSelective(List<ShyEmployee> shyEmployeeList) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Integer id) {
        return 0;
    }
}
