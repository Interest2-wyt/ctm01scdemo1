package com.wangyongtao.serverconsumer4.serverconsumer4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableHystrixDashboard
@EnableTurbine
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.wangyongtao.serverconsumer4.serverconsumer4"})
public class Serverconsumer4HystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(Serverconsumer4HystrixApplication.class, args);
    }

}
