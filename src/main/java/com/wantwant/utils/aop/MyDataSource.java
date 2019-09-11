package com.wantwant.utils.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义的数据源的注解
 * @author hy 孙浩月
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({
        ElementType.METHOD
})
public @interface MyDataSource {
    String value() default "defaultData";
}

