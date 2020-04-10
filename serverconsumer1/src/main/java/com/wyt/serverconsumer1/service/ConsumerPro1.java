package com.wyt.serverconsumer1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author : wangyongtao
 * @Description : 编辑服务1提供的服务
 * @Date : 2020/3/22 0022 17:54
 **/
@Service
public class ConsumerPro1 {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * @Method : 通过rest调用另外的服务
     * @Description : TODO
     **/
    public String getInfoByRest(){
        RestTemplate rest = new RestTemplate();
        return rest.getForObject("http://192.168.1.167:17011/ctm01scdemo1/serverprovider1/webControl/getString",String.class);
    }

    /**
     * @Method : 通过eureka服务寻址调用其他服务
     * @Description : TODO
     **/
    public String getInfoByAddr(){
        return restTemplate.getForObject("http://provider1/ctm01scdemo1/serverprovider1/webControl/getString",String.class);
    }
}
