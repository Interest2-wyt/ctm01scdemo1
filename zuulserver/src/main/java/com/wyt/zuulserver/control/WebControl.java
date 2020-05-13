package com.wyt.zuulserver.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : wangyongtao
 * @Description : TODO
 * @Date : 2020/5/13 0013 10:09
 **/
@RestController
@RequestMapping("/webControl")
public class WebControl {

    @GetMapping("/getString")
    public String getString(){
        return "success webcontrol";
    }


}
