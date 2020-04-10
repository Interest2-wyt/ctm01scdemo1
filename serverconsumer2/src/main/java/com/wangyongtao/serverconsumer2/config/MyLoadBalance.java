package com.wangyongtao.serverconsumer2.config;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

/**
 * @Author : wangyongtao
 * @Description : 自定义注解，从而可以使得注解的自定义拦截器起作用
 * @Date : 2020/4/5 0005 21:37
 **/
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Qualifier
public @interface MyLoadBalance {
}
