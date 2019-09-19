package com.wantwant;


import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.bstek.ureport.console.UReportServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
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
    /**
     * 使用@Bean注解注入第三方的解析框架（ureport）
     */
    @Bean
    public ServletRegistrationBean ureportServlet(){
        ServletRegistrationBean bean=new ServletRegistrationBean(new UReportServlet());
        bean.addUrlMappings("/ureport/*");
        return bean;
    }

    /**
     * 使用@Bean注解注入第三方的解析框架（fastJson）
     */
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters(){
        //1、首先需要先定义一个convert转换消息对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        //2、添加fastJson的配置信息，比如：是否要格式化返回的json数据
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //3、在convert中添加配置信息
        fastConverter.setFastJsonConfig(fastJsonConfig);

        return new HttpMessageConverters(fastConverter);
    }

}
