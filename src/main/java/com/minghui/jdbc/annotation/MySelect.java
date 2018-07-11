package com.minghui.jdbc.annotation;

import java.lang.annotation.*;

/**
 * 模拟mybatis的@Select注解
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MySelect {
    String value();
}
