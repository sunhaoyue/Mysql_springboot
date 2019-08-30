package com.wantwant.service;


import com.wantwant.pojo.AntiTest;
import org.apache.ibatis.annotations.Param;


import java.util.Date;
import java.util.List;

/**
 * @program: Sqlserver_springboot
 * @descript
 * ion: 服务层与数据映射层的服务接口
 * @author: Sunhaoyue
 * @create: 2019/06/17 16:41
 */
public interface AntiTestService {
    //查询所有table
    List<AntiTest> selectAllAntiTest();
    //按条件查询所有table
    List<AntiTest> selectAntiTest(@Param("anti_id") String anti_id, @Param("anti_name") String anti_name, @Param("anti_createdate") Date anti_createdate , @Param("anti_cnt") String anti_cnt);
    //查询设备详情
    AntiTest getDetailAntiTestById(@Param("anti_id") Integer id);
    //根据id删除记录
    int delAntiTestById(Integer id);
    //条件查询
    //List<AntiTest> selectAntiTest(@Param("compute_name") String computename, @Param("id") long id, @Param("createdate") Date createdate , @Param("computecnt") long computecnt);

    //新增
    void insertAntiTest(AntiTest antiTest);
    //编辑
    void editAntiTest(AntiTest antiTest);



}
