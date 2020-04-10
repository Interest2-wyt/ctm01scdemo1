package com.wangyongtao.serverconsumer2.interceptor;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.net.URI;

/**
 * @Author : wangyongtao
 * @Description : 自定义拦截器，验证@LoadBalanced的原理
 * @Date : 2020/4/5 0005 21:32
 **/
public class MyLoadBalancerInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        final URI originalUri = httpRequest.getURI();
        String serviceName = originalUri.getHost();
        System.out.println ("进入自定义的请求拦截器中叫："+serviceName);
        return clientHttpRequestExecution.execute(httpRequest, bytes);
    }
}
