package com.wantwant.mapper;

import com.wantwant.pojo.ShyEmployee;

public interface ShyEmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShyEmployee record);

    int insertSelective(ShyEmployee record);

    ShyEmployee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShyEmployee record);

    int updateByPrimaryKey(ShyEmployee record);
}