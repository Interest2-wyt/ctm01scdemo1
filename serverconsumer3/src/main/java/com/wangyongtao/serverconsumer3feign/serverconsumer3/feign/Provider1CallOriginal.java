package com.wangyongtao.serverconsumer3feign.serverconsumer3.feign;

import feign.RequestLine;

/**
 * @Author : wangyongtao
 * @Description : 原生的feign使用
 * @Date : 2020/4/6 0006 19:57
 **/
public interface Provider1CallOriginal {

    @RequestLine("GET /ctm01scdemo1/serverprovider1/serverControl/helloPort")
    public String callHello();
}
