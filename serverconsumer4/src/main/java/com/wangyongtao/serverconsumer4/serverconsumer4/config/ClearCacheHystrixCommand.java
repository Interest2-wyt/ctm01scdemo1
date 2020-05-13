package com.wangyongtao.serverconsumer4.serverconsumer4.config;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixRequestCache;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;
import lombok.Data;

/**
 * @Author : wangyongtao
 * @Description : hystrix缓存类
 * @Date : 2020/5/11 0011 14:04
 **/
@Data
public class ClearCacheHystrixCommand extends HystrixCommand<String> {
    private final String name;
    private static  final HystrixCommandKey GETTER_KEY = HystrixCommandKey.Factory.asKey("MyKey");

    public ClearCacheHystrixCommand(String name) {
        super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("MyGroup")).andCommandKey(GETTER_KEY));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        System.out.println("test cache");
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

    //清除缓存
    public static void flushCache(String name){
        HystrixRequestCache.getInstance(GETTER_KEY,HystrixConcurrencyStrategyDefault.getInstance()).clear(name);
    }
}
