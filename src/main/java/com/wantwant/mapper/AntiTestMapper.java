package com.wantwant.mapper;

import com.wantwant.pojo.AntiTest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
/**
 * @program: Sqlserver_springboot
 * @description: 相当与是dao包
 * @author: Sunhaoyue
 * @create: 2019/06/18 11:34
 */
@Mapper
public interface AntiTestMapper {

    List<AntiTest> selectAllAntiTest();
    //查询所有table
    List<AntiTest> selectAntiTest(@Param("anti_id") String anti_id, @Param("anti_name") String anti_name, @Param("anti_createdate") Date anti_createdate ,@Param("anti_cnt") String anti_cnt);

    AntiTest getDetailAntiTestById(@Param("anti_id") Integer id);

    int delAntiTestById(Integer id);
    //新增
    void insertAntiTest(AntiTest record);
    //编辑
    void editAntiTest(AntiTest antiTest);



}