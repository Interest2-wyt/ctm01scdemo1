package com.wyt.serverprovider1.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : wangyongtao
 * @Description : TODO
 * @Date : 2020/3/22 0022 17:26
 **/
@RestController
@RequestMapping("/webControl")
public class WebControl {
    @RequestMapping("/getString")
    public String getString(){
        return "success";
    }
}
