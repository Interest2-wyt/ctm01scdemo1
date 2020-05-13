package com.wangyongtao.serverconsumer4.serverconsumer4.hystrix;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.wangyongtao.serverconsumer4.serverconsumer4.config.ClearCacheHystrixCommand;
import com.wangyongtao.serverconsumer4.serverconsumer4.config.MyHystrixCommand;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Author : wangyongtao
 * @Description : 原生hystrix的调用
 * @Date : 2020/4/6 0006 21:05
 **/
public class OriginalHystrixUse {

    //同步执行
    public static void synchroCall(){
        String result= new MyHystrixCommand( "yinjihuan").execute();
        System.out.println(result);
    }

    //异步执行
    public static void asynchroCall(){
        Future<String> future = new MyHystrixCommand("yinjihuan").queue();
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    //测试hystrix提供的方法级别缓存的使用
    public static void cacheCall(){
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        String result= new MyHystrixCommand( "yinjihuan").execute();
        System.out.println(result);
        Future<String> future = new MyHystrixCommand("yinjihuan").queue();
        try {
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        context.shutdown();
    }

    //测试hystrix提供的方法级别缓存的清除
    public static void cacheFlush(){
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        String result= new ClearCacheHystrixCommand( "yinjihuan").execute();
        System.out.println(result);
        ClearCacheHystrixCommand.flushCache("yinjihuan");
        Future<String> future = new ClearCacheHystrixCommand("yinjihuan").queue();
        try {
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        context.shutdown();
    }

    public static void main(String[] args) {
        cacheFlush();
    }
}
