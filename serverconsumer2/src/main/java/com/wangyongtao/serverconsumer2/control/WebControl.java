package com.wangyongtao.serverconsumer2.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : wangyongtao
 * @Description : TODO
 * @Date : 2020/3/29 0029 22:10
 **/
@RestController
@RequestMapping("/webControl")
public class WebControl {

    @RequestMapping("/getString")
    public String getString(){
        return "success";
    }

}
