package com.wangyongtao.serverconsumer3feign.serverconsumer3.control;

import com.wangyongtao.serverconsumer3feign.serverconsumer3.feign.Provider1CallFeign;
import com.wangyongtao.serverconsumer3feign.serverconsumer3.feign.Provider1CallOriginal;
import feign.Feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author : wangyongtao
 * @Description : feign提供对应接口的地方
 * @Date : 2020/4/6 0006 18:04
 **/
@RestController
@RequestMapping("/feignCallControl")
public class FeignCallControl {

    @Autowired
    private RestTemplate restTemplate ;

    @Autowired
    private Provider1CallFeign provider1CallFeign;


    @GetMapping("/callHello")
    public String callHello(){
        String result = restTemplate.getForObject("http://provider1//ctm01scdemo1/serverprovider1/serverControl/helloPort",String.class);
        System.out.println("restTemplate调用结果："+result);
        return "restTemplate调用结果："+result;
    }

    /**
     * feign调用
     */
    @GetMapping("/callHello2")
    public String callHello2(){
        String result = provider1CallFeign.callHello();
        System.out.println("feignClient调用结果："+result);
        return "feignClient调用结果："+result;
    }

    /**
     * 原生的feign调用
     */
    @GetMapping("/callHello3")
    public String callHello3(){
        Provider1CallOriginal original = Feign.builder().target(Provider1CallOriginal.class,"http://localhost:17011/");
        System.out.println("原生feign调用结果："+original.callHello());
        return "原生feign调用结果："+original.callHello();
    }




}
