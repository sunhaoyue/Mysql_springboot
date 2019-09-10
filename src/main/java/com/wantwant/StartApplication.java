package com.wantwant;


import com.bstek.ureport.console.UReportServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

/**
 * @program: Mysql_springboot
 * @description: 应用启动入口
 * @author: Sunhaoyue
 * @create: 2019/06/17 15:04
 */
@SpringBootApplication
public class StartApplication {
    public static void main(String[] args)  {
        SpringApplication.run(StartApplication.class, args);
    }
    @Bean
    public ServletRegistrationBean ureportServlet(){
        ServletRegistrationBean bean=new ServletRegistrationBean(new UReportServlet());
        bean.addUrlMappings("/ureport/*");
        return bean;
    }
}
