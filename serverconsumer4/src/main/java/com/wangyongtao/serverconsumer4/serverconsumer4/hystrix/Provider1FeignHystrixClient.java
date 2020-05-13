package com.wangyongtao.serverconsumer4.serverconsumer4.hystrix;

import com.wangyongtao.serverconsumer4.serverconsumer4.feign.Provider1CallFeign;
import org.springframework.stereotype.Component;

/**
 * @Author : wangyongtao
 * @Description : 对于feign的调用提供方法级别的熔断
 * @Date : 2020/5/11 0011 17:18
 **/
@Component
public class Provider1FeignHystrixClient implements Provider1CallFeign {
    @Override
    public String callHello() {
        return "feign hystrix protect";
    }
}
