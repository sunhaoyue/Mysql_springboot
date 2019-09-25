# Mysql_springboot
标准依赖  
 <!-- pom.xml -->
>  <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.boot</groupId>
    <artifactId>testSpringBoot</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>testSpringBoot</name>
    <packaging>jar</packaging>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.5.9.RELEASE</version>
        <relativePath/>
    </parent>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        
        <!-- mybatis依赖 -->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.3.1</version>
        </dependency>
        
        <!-- 引入thymelaf 则不需要引入web依赖，若不需要thymelaf则需要添加spring-boot-starter-web -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
        
        <!-- mysql依赖 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
        
         <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-test</artifactId>
        </dependency>
    </dependencies>
    <build>
    <plugins>
        <!-- 要使生成的jar可运行，需要加入此插件 -->
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
</project>

二、资源加载视图图例  

1、登录界面
![Image text](https://github.com/sunhaoyue/Mysql_springboot/blob/master/%E7%99%BB%E5%BD%95%E9%A1%B5%E9%9D%A2.png
)
2、get所有数据展示
![Image text](https://github.com/sunhaoyue/Mysql_springboot/blob/master/%E6%89%80%E6%9C%89list.png)
3、按照条件查询展示
![Image text](https://github.com/sunhaoyue/Mysql_springboot/blob/master/%E6%9D%A1%E4%BB%B6list.png)
4、错误显示页面
![Image text](https://github.com/sunhaoyue/sqlserver_springboot/blob/master/%E5%B1%8F%E5%B9%95%E5%BF%AB%E7%85%A7%202019-07-04%20%E4%B8%8B%E5%8D%882.08.17.png)
5、Ureport报表
http://localhost:8088/Mysql_springboot/ureport/designer
![Image text](https://github.com/sunhaoyue/Mysql_springboot/blob/master/ureport%E6%8A%A5%E8%A1%A8%E5%BC%95%E6%93%8E.png)
6、title小图标浏览器
![Image text]https://github.com/sunhaoyue/Mysql_springboot/blob/master/title%E5%B0%8F%E5%9B%BE%E6%A0%87%E6%B5%8F%E8%A7%88%E5%99%A8.png
7、解决分页问题
![Image text]https://github.com/sunhaoyue/Mysql_springboot/blob/master/%E8%A7%A3%E5%86%B3%E5%88%86%E9%A1%B5%E9%97%AE%E9%A2%98.png
