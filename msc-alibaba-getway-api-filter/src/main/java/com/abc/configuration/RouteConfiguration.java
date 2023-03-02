package com.abc.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: RouteConfiguration
 * @Author: 青衣醉
 * @Date: 2023/2/28 10:34 下午
 */
@Configuration
public class RouteConfiguration {
    //Path配置路由规则： 可以配置多个路径的拦截规则
    @Bean
    public RouteLocator someRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(ps -> ps.path("/provider/**")
                        .uri("lb://msc-alibaba-producer")
                        .id("path_provider_route"))
                .route(ps -> ps.path("/consumer/**")
                        .uri("lb://msc-alibaba-consumer")
                        .id("path_consumer_route"))
                .build();
    }
}
