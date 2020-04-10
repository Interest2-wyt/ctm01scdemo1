package com.wangyongtao.serverconsumer4.serverconsumer4.hystrix;

import com.wangyongtao.serverconsumer4.serverconsumer4.config.MyHystrixCommand;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Author : wangyongtao
 * @Description : 原生hystrix的调用
 * @Date : 2020/4/6 0006 21:05
 **/
public class OriginalHystrixUse {

    public static void synchroCall(){
        String result= new MyHystrixCommand( "yinjihuan").execute();
        System.out.println(result);
    }

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

    public static void main(String[] args) {
        synchroCall();
    }
}
