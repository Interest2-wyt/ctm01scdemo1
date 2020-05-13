package com.wangyongtao.serverconsumer4.serverconsumer4.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author : wangyongtao
 * @Description : 配置管理需要的bean
 * @Date : 2020/3/22 0022 18:25
 **/
@Configuration
public class BeanConfiguration {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
