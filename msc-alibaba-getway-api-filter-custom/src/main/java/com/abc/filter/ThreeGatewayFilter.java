package com.abc.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Description: 目标：查看过滤器执行顺序，观察pre过滤和post过滤
 * 过滤器一
 * @Author: 青衣醉
 * @Date: 2023/3/20 8:42 下午
 */
public class ThreeGatewayFilter implements GatewayFilter {
    // 过滤器三
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //系统时间
        System.out.println ("pre-filter-【333】 ");
        return chain.filter (exchange).then (Mono.fromRunnable (()->{
            System.out.println ("post-filter-【333】 ");
        }));
    }
}
