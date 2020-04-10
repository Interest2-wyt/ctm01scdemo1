package com.wangyongtao.serverconsumer2.ribbon;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.LoadBalancerBuilder;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @Author : wangyongtao
 * @Description : TODO
 * @Date : 2020/4/6 0006 14:06
 **/
public class MyRule implements IRule {
    private ILoadBalancer lb ;

    @Override
    public Server choose(Object o) {
        List<Server> servers= lb.getAllServers();
        for (Server server : servers) {
            System.out.println(server.getHostPort());
        }
        return servers.get(0);
    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {
        this.lb = iLoadBalancer;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return lb;
    }
}
