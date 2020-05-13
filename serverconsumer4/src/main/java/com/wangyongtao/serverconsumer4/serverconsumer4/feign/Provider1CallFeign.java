package com.wangyongtao.serverconsumer4.serverconsumer4.feign;

import com.wangyongtao.serverconsumer4.serverconsumer4.config.FeignLoggerConfiguration;
import com.wangyongtao.serverconsumer4.serverconsumer4.hystrix.Provider1FeignHystrixClient;
import com.wangyongtao.serverconsumer4.serverconsumer4.hystrix.Provider1FeignHystrixClient2;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author : wangyongtao
 * @Description : 定义feign调用的api，之后就可以以方法调用的方式调用远程方法
 * @Date : 2020/4/6 0006 18:06
 **/
@FeignClient(value = "provider1",path = "/ctm01scdemo1/serverprovider1/serverControl",configuration = FeignLoggerConfiguration.class,fallbackFactory = Provider1FeignHystrixClient2.class)
public interface Provider1CallFeign {

    @GetMapping("/helloPort")
    public String callHello();
}
