package com.wyt.zuulserver.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : wangyongtao
 * @Description : zuul路由所在的请求类
 * @Date : 2020/5/13 0013 10:23
 **/
@RestController
@RequestMapping("/zuulRoute")
public class RouteControl {

    @GetMapping("getString")
    public String getString(){
        return "success route";
    }

}
