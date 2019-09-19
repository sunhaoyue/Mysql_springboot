package com.wantwant.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wantwant.pojo.ShyEmployee;
import com.wantwant.service.ShyemployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: Mysql_springboot
 * @description: 用户信息控制
 * @author: Sunhaoyue
 * @create: 2019/09/17 16:10
 */
@Controller
public class ShyEmployeeController {

    @Autowired
    private ShyemployeeService shyemployeeService;

    //http://localhost:8088/Mysql_springboot/emp/basic?id=&pageNum=9 分页登录地址， 地址有bug，需要调整
    //显示所用用户
    @ResponseBody
    @RequestMapping("/emp/basic")
    public ModelAndView getShyEmployee(@RequestParam("id") Integer id, Model model,
                                       @RequestParam(value = "pageNum", defaultValue = "0") Integer pageNum,
                                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize){

        System.out.println("============================");
        //为了程序的严谨性，判断非空：
        if(pageNum == null){
            pageNum = 1;   //设置默认当前页
        }
        if(pageNum <= 0){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 5;    //设置默认每页显示的数据数
        }
        System.out.println("当前页是："+pageNum+"显示条数是："+pageSize);

        //1.引入分页插件,pageNum是第几页，pageSize是每页显示多少条,默认查询总数count
        PageHelper.startPage(pageNum,pageSize);
        //2.紧跟的查询就是一个分页查询-必须紧跟.后面的其他查询不会被分页，除非再次调用PageHelper.startPage
        try{
            List<ShyEmployee> emp_lists=shyemployeeService.selectByPrimaryKey(id);
            System.out.println("分页数据："+emp_lists);
            PageInfo<ShyEmployee> pageInfo =new PageInfo<ShyEmployee>(emp_lists,pageSize);
            System.out.println("总页数" + emp_lists.size()/pageSize);
            System.out.println("当前页是：" + pageNum);
            System.out.println("分页数据：");
            model.addAttribute("pageInfo",pageInfo);

            System.out.println(pageInfo.getList().listIterator());
        }finally{
            PageHelper.clearPage();
        }
        return new ModelAndView("emp_basic");
    }
}
