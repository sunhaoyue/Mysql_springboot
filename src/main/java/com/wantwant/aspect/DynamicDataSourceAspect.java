package com.wantwant.aspect;

import com.wantwant.utils.DynamicDataSourceSwitcher;
import com.wantwant.utils.aop.MyDataSource;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 创建aop切面
 * @author hy 孙浩月
 */
@Aspect
@Component
@Order(1) //需要加入切面排序
public class DynamicDataSourceAspect {
    private Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    /**
     * 切入点只对@Service注解的类上的@DataSource方法生效
     * @param myDataSource
     */
    @Pointcut(value="@within(org.springframework.stereotype.Service) && @annotation(myDataSource)" )
    public void dynamicDataSourcePointCut(MyDataSource myDataSource){}

    @Before(value = "dynamicDataSourcePointCut(myDataSource)")
    public void switchDataSource(MyDataSource myDataSource) {
        DynamicDataSourceSwitcher.setDataSource(myDataSource.value());
    }

    /**
     * 切点执行完后 切换成主数据库
     * @param myDataSource
     */
    @After(value="dynamicDataSourcePointCut(myDataSource)")
    public void after(MyDataSource myDataSource){
        DynamicDataSourceSwitcher.cleanDataSource();
    }
}

