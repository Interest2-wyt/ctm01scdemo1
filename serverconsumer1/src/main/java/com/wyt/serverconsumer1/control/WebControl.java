package com.wyt.serverconsumer1.control;

import com.wyt.serverconsumer1.service.ConsumerPro1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : wangyongtao
 * @Description : TODO
 * @Date : 2020/3/22 0022 17:57
 **/
@RestController
@RequestMapping("/webControl")
public class WebControl {
    @Autowired
    private ConsumerPro1 consumerPro1;

    @GetMapping("/getStringByRest")
    public String getStringByRest(){
        return consumerPro1.getInfoByRest();
    }

    @GetMapping("/getStringByAddr")
    public String getStringByAddr(){
        return consumerPro1.getInfoByAddr();
    }

    @GetMapping("/getString")
    public String getString(){
        return "success devtool";
    }

}
