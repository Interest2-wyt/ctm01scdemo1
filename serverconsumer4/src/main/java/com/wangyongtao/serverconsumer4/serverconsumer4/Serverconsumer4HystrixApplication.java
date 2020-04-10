package com.wangyongtao.serverconsumer4.serverconsumer4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Serverconsumer4HystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(Serverconsumer4HystrixApplication.class, args);
    }

}
