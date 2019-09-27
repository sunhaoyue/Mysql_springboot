package com.wantwant.controller;

import com.wantwant.pojo.ShyUser;
import com.wantwant.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: Mysql_springboot
 * @description: 登录控制层
 * @author: Sunhaoyue
 * @create: 2019/09/02 15:06
 */

@Controller
public class LoginController {


    @Autowired
    private LoginServiceImpl loginService;

    //处理前端保存数据到数据库
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = {"/login"})
    public String loginHtml() {
        return "login";
    }

    @RequestMapping(value = {"/userLogin"})
    public ModelAndView userLogin(@RequestParam("username") String username,
                                  @RequestParam("password") String password) {
        ModelAndView mv = new ModelAndView("index");
        ModelAndView mv2 = new ModelAndView("login");
        ShyUser people = loginService.userlogin(username, password);
        if (people != null) {
            String peoplename = people.getUserLoginName();
            mv.addObject("name", peoplename);
            System.out.println(peoplename+"登录过中。。。!");
            return mv;
        }else{
            //登录失败，重新登录
            System.out.println("您提供的凭证有误!");
            mv2.addObject("msg","您提供的凭证有误!");
            return mv2;
        }
        //System.out.println("登录结束");
    }



  /*  @RequestMapping("/registerHtml")
    public String registerpage() {
        return "register";
    }

    @ResponseBody
    @RequestMapping("/uregister")
    public String addUser(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("password2") String password2,
                          @RequestParam("createdate") Date createdate,
                          @RequestParam("computecnt") String computecnt) {

        if ((username == null) || (username == "") || (password == null) || (password == "") || (createdate == null) || (computecnt == null) || (computecnt == "")) {
            return "redirect:/registerpage";
        } else {
            if (!password.equals(password2)) {

                return "两次密码不相同，注册失败！！";
            } else {
                int res = loginService.adduser(username, password, createdate, computecnt);

                if (res == 0) {
                    return "注册失败！";
                } else {
                    return "redirect:/selectAllAntiTest";
                }
            }
        }
    }*/
}
