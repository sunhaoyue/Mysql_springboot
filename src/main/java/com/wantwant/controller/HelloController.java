package com.wantwant.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: Sqlserver_springboot
 * @description: 测试springboot 视图配置
 * @author: Sunhaoyue
 * @create: 2019/06/18 11:26
 */

@RestController
public class HelloController {
    @RequestMapping(value ="/")
    public String home(){
        System.out.println("springboot启动文本视图显示");
        return "欢迎来到王者荣耀 ，测试springboot实现文本输出!";
    }

}
