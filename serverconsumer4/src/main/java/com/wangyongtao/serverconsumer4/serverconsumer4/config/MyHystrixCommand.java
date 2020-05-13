package com.wangyongtao.serverconsumer4.serverconsumer4.config;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @Author : wangyongtao
 * @Description : 自定义hystrix
 * @Date : 2020/4/6 0006 21:06
 **/
public class MyHystrixCommand extends HystrixCommand<String> {
    private String name;

    public MyHystrixCommand(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("MyGroup"));
        this.name =  name;
    }

    @Override
    protected String run() throws Exception {
        try {
//            Thread.sleep(10*1000);
            System.out.println("test cache");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.name + ":" + Thread.currentThread().getName();
    }

    @Override
    protected String getFallback() {
        return "失败了，这是回退方法返回信息！";
    }

    /**
     * hystrix 提供了方法级别的缓存
     */
    @Override
    protected String getCacheKey() {
        return String.valueOf(this.name);
    }

}
