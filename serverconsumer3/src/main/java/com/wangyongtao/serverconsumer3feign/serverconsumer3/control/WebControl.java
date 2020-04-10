package com.wangyongtao.serverconsumer3feign.serverconsumer3.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : wangyongtao
 * @Description : 基础控制器，一般可用于测试该服务是否可正常访问
 * @Date : 2020/4/6 0006 18:03
 **/
@RestController
@RequestMapping("/webControl")
public class WebControl {

    @GetMapping("/getString")
    public String getString(){
        return "success";
    }

}
