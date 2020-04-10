package com.wangyongtao.serverconsumer3feign.serverconsumer3.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author : wangyongtao
 * @Description : 配置Feign日志输出内容
 *                  NONE ： 不输出日志 。
 *                  BASIC ： 只输出请求方法的 URL 和响应 的状态码以及接口 执行的时间 。
 *                  HEADERS ：将 BASIC 信息和请求头信息输出 。
 *                  FULL ：输出完整的请求信息 。
 * @Date : 2020/4/6 0006 18:14
 **/
@Configuration
public class LoggerConfiguration {
    /**
     * 配置Feign日志输出内容的范围，不包含日志级别配置，级别的配置在配置文件中指定
     * @return
     */
    @Bean
    public Logger.Level configFeignLogger(){
        return  Logger.Level.FULL;
    }
}
