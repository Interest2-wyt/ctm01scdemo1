package com.wangyongtao.serverconsumer3feign.serverconsumer3.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author : wangyongtao
 * @Description : 配置类，主要是配置可以寻址和负载均衡使用的RestTemplste
 * @Date : 2020/4/5 0005 19:46
 **/
@Configuration
public class RestConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRibbonRest(){
        return new RestTemplate();
    }
}
