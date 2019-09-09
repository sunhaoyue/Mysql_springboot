package com.wantwant.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * @program: ww_flow_springboot
 * @description: 数据库连连接池Druid的配置
 * 查看数据监控信息
 *
 * 登录 url:http://127.0.0.1:8081/Sqlserver_springboot/druid/login.html
 *
 * @author: Sunhaoyue
 * @create: 2019/06/17 17:29
 */
@Configuration
public class DruidConfig {
    //配置一个管理后台的Servlet,SpringBoot配置Servlet的方式如下
    @Bean
    public ServletRegistrationBean druidServlet(){
         //创建servlet注册实体
        ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        //设置ip白名单
        servletRegistrationBean.addInitParameter("allow","127.0.0.1");
        //设置ip黑名单
        //servletRegistrationBean.addInitParameter("deny","192.168.0.2");
        //登录查看信息的账号密码
        servletRegistrationBean.addInitParameter("loginUsername","druid");
        servletRegistrationBean.addInitParameter("loginPassword","123456");
        //是否能够重置数据
        servletRegistrationBean.addInitParameter("resetEnable","false");
        return servletRegistrationBean;
    }

    //配置一个监控Filter
    @Bean
    public FilterRegistrationBean druidStatFilter(){
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions","*.html,*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
    //配置多数据源
}
