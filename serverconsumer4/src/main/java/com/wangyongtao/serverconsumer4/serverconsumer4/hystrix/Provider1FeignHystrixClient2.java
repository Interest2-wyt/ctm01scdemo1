package com.wangyongtao.serverconsumer4.serverconsumer4.hystrix;

import com.wangyongtao.serverconsumer4.serverconsumer4.feign.Provider1CallFeign;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Author : wangyongtao
 * @Description : 实现FallbackFactory接口，除了熔断保护外，还可以返回熔断的原因
 * @Date : 2020/5/11 0011 17:48
 **/
@Component
public class Provider1FeignHystrixClient2 implements FallbackFactory<Provider1CallFeign> {
    @Override
    public Provider1CallFeign create(Throwable throwable) {
        return new Provider1CallFeign() {
            @Override
            public String callHello() {
                return "feign hystrix protect"+throwable.getMessage();
            }
        };
    }
}
