package com.wangyongtao.serverconsumer2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Serverconsumer2RibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(Serverconsumer2RibbonApplication.class, args);
    }

}
