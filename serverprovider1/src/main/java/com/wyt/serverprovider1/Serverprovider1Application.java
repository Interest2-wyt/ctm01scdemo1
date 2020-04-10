package com.wyt.serverprovider1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Serverprovider1Application {

    public static void main(String[] args) {
        SpringApplication.run(Serverprovider1Application.class, args);
    }

}
