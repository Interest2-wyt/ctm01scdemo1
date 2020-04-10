package com.wangyongtao.serverconsumer2.ribbon;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.LoadBalancerBuilder;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.reactive.LoadBalancerCommand;
import com.netflix.loadbalancer.reactive.ServerOperation;
import org.springframework.web.bind.annotation.RestController;
import rx.Observable;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author : wangyongtao
 * @Description : ribbon调用测试类
 * @Date : 2020/3/29 0029 22:09
 **/
@RestController
public class OriginalRibbonCall {

    /**
     * @Method :
     * @Description : 原生robbon调用
     **/
    public void ribbonConsumer(){
        List<Server> serverList = new ArrayList<>();
        serverList.add(new Server("localhost", 17011));
        serverList.add(new Server ("localhost", 17012));

        ILoadBalancer loadBalancer = LoadBalancerBuilder.newBuilder()
                    .buildFixedServerListLoadBalancer(serverList);

        for (int i = 0; i < 5; i ++) {
            String result= LoadBalancerCommand.<String>builder()
                    . withLoadBalancer(loadBalancer)
                    .build()
                    .submit(new ServerOperation<String>() {
                                public Observable<String> call(Server server) {
                                    try {
                                        String addr = "http://" + server.getHost() + ":" + server.getPort() + "/ctm01scdemo1/serverprovider1/serverControl/personInfo";
                                        System.out.println(" 调用地址 ：" + addr);
                                        URL url = new URL(addr);
                                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                                        conn.setRequestMethod("GET");
                                        conn.connect();
                                        InputStream in = conn.getInputStream();

                                        return Observable.just(new String("123"));
                                    } catch (Exception e) {
                                        return Observable.error(e);
                                    }
                                }
                    }).toBlocking().first();
            System.out.println(" 调用结果 ： " + result);
        }
    }

    public static void main(String[] args) {
        OriginalRibbonCall consumerServerControl = new OriginalRibbonCall();
        consumerServerControl.ribbonConsumer();
    }


}
