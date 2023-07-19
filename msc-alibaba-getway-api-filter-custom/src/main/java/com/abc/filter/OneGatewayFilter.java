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
public class OneGatewayFilter implements GatewayFilter {
    // 过滤器一
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //系统时间
        long startTime = System.currentTimeMillis ();
        System.out.println ("pre-filter-【111】 " + startTime);
        //设置filter过滤时间
        exchange.getAttributes ().put ("startTime",startTime);
        return chain.filter (exchange).then (Mono.fromRunnable (()->{
            System.out.println ("post-filter-【111】 ");
            //获取过滤开始时间
            Long startTimeArr = (Long)exchange.getAttribute ("startTime");
            //获取filter过滤结束时间
            long endTimeArr = System.currentTimeMillis ();
            System.out.println ("OneGatewayFilter过滤执行时间"+(endTimeArr-startTimeArr));
        }));
    }
}
