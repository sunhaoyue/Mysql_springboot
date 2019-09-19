package com.wantwant.mapper;

import com.wantwant.pojo.ShyEmployee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShyEmployeeMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(ShyEmployee record);

    int insertSelective(ShyEmployee record);

    //获取所有用户数据
    List<ShyEmployee> selectByPrimaryKey(@Param("id")Integer id);

    int updateByPrimaryKeySelective(ShyEmployee record);

    int updateByPrimaryKey(ShyEmployee record);
}