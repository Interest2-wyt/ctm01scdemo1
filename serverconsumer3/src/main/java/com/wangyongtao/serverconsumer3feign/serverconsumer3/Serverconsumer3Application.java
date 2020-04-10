package com.wangyongtao.serverconsumer3feign.serverconsumer3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.wangyongtao.serverconsumer3feign.serverconsumer3")
public class Serverconsumer3Application {
    public static void main(String[] args) {
        SpringApplication.run(Serverconsumer3Application.class, args);
    }

}
