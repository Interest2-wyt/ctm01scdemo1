package com.wangyongtao.serverconsumer2.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author : wangyongtao
 * @Description : 通过restTemplate测试ribbon的负载均衡调用
 * @Date : 2020/4/5 0005 18:50
 **/
@RestController
@RequestMapping("/restControl")
public class RestControl {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/callHello")
    public String callHello(){
        String result = restTemplate.getForObject("http://provider1//ctm01scdemo1/serverprovider1/serverControl/helloPort",String.class);
        System.out.println("restTemplate调用结果："+result);
        return "restTemplate调用结果："+result;
    }

    @GetMapping("/chooseService")
    public Object chooseService(){
        String name = "provider1";
        ServiceInstance instance = loadBalancerClient.choose(name);
        return instance;
    }
}
