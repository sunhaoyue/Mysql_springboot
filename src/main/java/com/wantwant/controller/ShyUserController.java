package com.wantwant.controller;

import com.wantwant.pojo.ShyUser;
import com.wantwant.service.ShyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @program: Mysql_springboot
 * @description: 用户管理控制层，注册
 * @author: Sunhaoyue
 * @create: 2019/09/03 15:22
 */

@Controller
public class ShyUserController {

    @Autowired
    private ShyUserService shyUserService;
    //处理前端保存数据到数据库
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }



    //显示所用用户
    @ResponseBody
    @RequestMapping("/show_shyuser")
    public ModelAndView getShyUser(@RequestParam("id") Long id, Model model){
        List<ShyUser> userlist=shyUserService.selectByPrimaryKey(id);
        System.out.println(userlist.size()+"用户数");
        model.addAttribute("user_lists",userlist);
        return new ModelAndView("userlist");

    }
}
