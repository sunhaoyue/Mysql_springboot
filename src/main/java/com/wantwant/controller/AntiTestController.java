package com.wantwant.controller;

import com.wantwant.pojo.AntiTest;
import com.wantwant.pojo.Common;
import com.wantwant.service.impl.AntiTestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @program: Sqlserver_springboot
 * @description: 电脑视图控制层
 * @author: Sunhaoyue
 * @create: 2019/06/17 16:44
 */

@Controller
public class AntiTestController {
    @Autowired
    private AntiTestServiceImpl antiTestService;

    //处理前端保存数据到数据库
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    //查询所有的设备
    @ResponseBody
    @RequestMapping("/selectAllAntiTest")
    public ModelAndView getAllAntiTest(Model model) {
        List<AntiTest> list =antiTestService.selectAllAntiTest();
        System.out.println(list.size());
        System.out.println(list);
        System.out.println(list.get(1).getComputername());
        model.addAttribute("anti_tests",list);
        return new ModelAndView("show_table");
    }
    //按条件查询所有的设备
    @ResponseBody
    @RequestMapping("/selectAntiTest")
    public ModelAndView getAntiTest(@RequestParam("anti_id") String anti_id,
                                       @RequestParam("anti_name") String anti_name,
                                       @RequestParam("anti_createdate") Date anti_createdate,
                                       @RequestParam("anti_cnt") String anti_cnt,Model model,Common common) {
        //String anti_createdate1=anti_createdate.toString();
        //System.out.println("String装换后"+anti_createdate1);
        List<AntiTest> list = antiTestService.selectAntiTest(anti_id,anti_name,anti_createdate,anti_cnt);
        System.out.println(list.size());
        System.out.println(list);
        System.out.println("设备名"+list.get(0).getComputername()+"时间："+list.get(0).getCreatedate());
        model.addAttribute("anti_tests",list);
        System.out.println("数据渲染中。。。。。");
        return new ModelAndView("show_table");
    }
    //删除用户信息
    @RequestMapping("/del")
    public String delAntiTestById(Integer id){
        antiTestService.delAntiTestById(id);
        return "redirect:/selectAllAntiTest";
    }
//    @ApiOperation("分页查询退货申请")
//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    @ResponseBody
//    public Object list(OmsReturnApplyQueryParam queryParam,
//                       @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
//                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
//        List<OmsOrderReturnApply> returnApplyList = returnApplyService.list(queryParam, pageSize, pageNum);
//        return new CommonResult().pageSuccess(returnApplyList);
//    }

    @RequestMapping("/edit")
    public String edit(ModelMap map, @RequestParam(defaultValue = "0") Integer id){
        //isAdd : 向前端页面返回一个是新增与编辑的标识
        if(id > 0){
            map.addAttribute("isAdd",false);
            System.out.println("执行到视图渲染，数据传输");
            AntiTest antiTest=antiTestService.getDetailAntiTestById(id);
            System.out.println(antiTest.getCreatedate());
            System.out.println(antiTest.getComputername());
            //simpleDateFormat.parse(antiTest.getCreatedate());
            //SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            //Date cd=simpleDateFormat.parse(antiTest.getCreatedate());
            //Date last=new Date(cd);//得到的值为空，所以报错！
            //antiTest.setCreatedate(last);
            map.addAttribute("anti_test",antiTest);
        }else{
            map.addAttribute("isAdd",true);
            map.addAttribute("anti_test",new AntiTest());
        }
        return "edit_table";
    }
    //新增和编辑
    //@ResponseBody
    @RequestMapping("/save")
    public String save(@ModelAttribute AntiTest antiTest){
        //SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        //Date date=new Date(String.valueOf(antiTest.getCreatedate()));
        //String time=
        System.out.println("编辑层创建时间："+antiTest.getCreatedate());
        System.out.println("编辑层数量："+antiTest.getCnt());
        if(antiTest == null){
            return "fail";
        }
        if(antiTest.getId() != null && antiTest.getId() > 0){
            antiTestService.editAntiTest(antiTest);
        }else{
            antiTestService.insertAntiTest(antiTest);
        }
        return "redirect:/selectAllAntiTest";
    }

}
