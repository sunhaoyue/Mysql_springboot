package com.wantwant.service.impl;


import com.wantwant.mapper.AntiTestMapper;
import com.wantwant.pojo.AntiTest;
import com.wantwant.service.AntiTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

/**
 * @program: Sqlserver_springboot
 * @description: ${description}
 * @author: Sunhaoyue
 * @create: 2019/06/17 16:48
 */
@Service("AntiTestServiceImpl")
public class AntiTestServiceImpl implements AntiTestService {

    @Autowired
    private AntiTestMapper antiTestMapper;
    //显示所有数据
    @Override
    public List<AntiTest> selectAllAntiTest() {
        List<AntiTest> listAll=antiTestMapper.selectAllAntiTest();
        System.out.println("service:"+listAll.size());
        System.out.println("service:"+listAll);
        System.out.println("service:"+listAll.get(0).getComputername());
        return listAll;
    }
    //按照条件显示所有数据
    @Override
    public List<AntiTest> selectAntiTest(String anti_id, String anti_name, Date anti_createdate, String anti_cnt) {
        //PageHelper.startPage(page,rows);
        List<AntiTest> list=antiTestMapper.selectAntiTest(anti_id,anti_name,anti_createdate,anti_cnt);
        System.out.println("service:"+list.size());
        System.out.println("service:"+list);
        System.out.println("service:"+list.get(0).getComputername());
        return list;
    }




    @Override
    public AntiTest getDetailAntiTestById(Integer id) {

        return antiTestMapper.getDetailAntiTestById(id);
    }


    @Override
    public int delAntiTestById(Integer id) {
        return antiTestMapper.delAntiTestById(id);
    }

    //新增
    @Override
    public void insertAntiTest(AntiTest antiTest) {
        antiTestMapper.insertAntiTest(antiTest);
    }

    //编辑
    @Override
    public void editAntiTest(AntiTest antiTest) {
        antiTestMapper.editAntiTest(antiTest);

    }


}
