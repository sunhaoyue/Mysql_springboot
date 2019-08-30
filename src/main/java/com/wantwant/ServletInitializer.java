package com.wantwant;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/**
 * @program: Sqlserver_springboot
 * @description: web运行入口
 * @author: Sunhaoyue
 * @create: 2019/07/04 12:04
 */


public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        //Application的类名
        return application.sources(StartApplication.class);
    }

}