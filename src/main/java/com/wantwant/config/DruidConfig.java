package com.wantwant.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.wantwant.utils.DynamicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


/**
 * @program: ww_flow_springboot
 * @description: 数据库连连接池Druid的配置
 * 查看数据监控信息
 *
 * 登录 url:http://127.0.0.1:8081/Mysql_springboot/druid/login.html
 *
 * @author: Sunhaoyue
 * @create: 2019/06/17 17:29
 */
@Configuration
public class DruidConfig {

   /* @Bean("defaultData")
    @ConfigurationProperties(prefix = "spring.datasource.druid.default")
    public DataSource createDefaultDataSource(){
        return new DruidDataSource();
    }
    @Bean("master")
    @ConfigurationProperties(prefix = "spring.datasource.druid.master")
    public DataSource createMasterDataSource(){
        return new DruidDataSource();
    }
    *//**
     * 设置动态数据源，通过@Primary 来确定主DataSource
     * @return
     *//*
    @Bean
    @Primary
    public DataSource createDynamicDataSource(@Qualifier("defaultData") DataSource defaultData,@Qualifier("master") DataSource master){
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        //设置默认数据源
        dynamicDataSource.setDefaultTargetDataSource(defaultData);
        //配置多数据源
        Map<Object, Object> map = new HashMap<>();
        map.put("defaultData",defaultData);
        map.put("master",master);
        dynamicDataSource.setTargetDataSources(map);
        return  dynamicDataSource;
    }*/
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
