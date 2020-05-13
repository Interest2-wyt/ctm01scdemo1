package com.wangyongtao.serverconsumer4.serverconsumer4.control;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.wangyongtao.serverconsumer4.serverconsumer4.feign.Provider1CallFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author : wangyongtao
 * @Description : 外界调用访问的类
 * @Date : 2020/5/11 0011 15:31
 **/
@RestController
@RequestMapping("/webControl")
public class WebControl {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Provider1CallFeign provider1CallFeign;

    @GetMapping("/getString")
    public String getString(){
        return "success33";
    }

    @GetMapping("/callHello")
    @HystrixCommand(fallbackMethod = "defaultCallHello")
    public String callHello(){
        String result = restTemplate.getForObject("http://provider1/ctm01scdemo1/serverprovider1/webControl/getString",String.class);
        return result;
    }
    /**
     * 纯hystrix的熔断方法
     */
    public String defaultCallHello(){
        return "fail";
    }

    /**
     * 将feign和hystrix集成，不用再control中手写返回方法。而是可以根据接口类整体进行编辑
     */
    @GetMapping("/callHelloByFeign")
    public String callHelloByFeignHystrix(){
        return provider1CallFeign.callHello();
    }


}
