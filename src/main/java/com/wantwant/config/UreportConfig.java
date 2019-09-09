package com.wantwant.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.bstek.ureport.console.UReportServlet;

import javax.servlet.Servlet;


/**
 * @program: Mysql_springboot
 * @description: ureport2配置类 报表引擎
 * @author: Sunhaoyue
 * @create: 2019/09/06 17:13
 */



@ImportResource("classpath:ureport-console-context.xml")
@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages = "com.wantwant.test")
public class UreportConfig {

    @Bean
    public ServletRegistrationBean<Servlet> buildUreportServlet() {
        return new ServletRegistrationBean<Servlet>(new UReportServlet(), "/ureport/*");
    }

}