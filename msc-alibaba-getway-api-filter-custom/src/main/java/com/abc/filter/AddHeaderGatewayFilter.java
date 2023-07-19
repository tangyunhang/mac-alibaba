package com.abc.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Description:
 * 目标L：自定义filter，拦截请求对象，并设置参数
 * 1。获取请求对象，并设置参数
 * 2。将请求对象设置到交换机exchange中
 * 3。放行请求
 * 4。在showinfo中，打印request的参数
 * @Author: 青衣醉
 * @Date: 2023/3/5 1:18 下午
 */
public class AddHeaderGatewayFilter implements GatewayFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //1、获取请求对象，并自定义参数
        ServerHttpRequest request = exchange.getRequest ().mutate ().header ("x-reqyest-red", "blue").build ();
        //2。将请求对象设置到交换机exchange中
        ServerWebExchange build = exchange.mutate ().request (request).build ();
        //3。放行请求
        return chain.filter (build);
        //4。在showinfo中，打印request的参数
    }
}
