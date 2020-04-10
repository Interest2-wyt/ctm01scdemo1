package com.wyt.serverconsumer1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Serverconsumer1Application {

    public static void main(String[] args) {
        SpringApplication.run(Serverconsumer1Application.class, args);
    }

}
