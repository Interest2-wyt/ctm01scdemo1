package com.wyt.serverprovider1.control;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : wangyongtao
 * @Description : 服务控制类，主要是向外提供服务
 * @Date : 2020/3/29 0029 21:37
 **/
@RestController
@RequestMapping("/serverControl")
public class ServerControl {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/personInfo")
    public String personInfo(){
        return "该接口提供人员信息服务！";
    }

    @GetMapping("/helloPort")
    public String helloPort(){
        return "hello "+ serverPort;
    }
}
