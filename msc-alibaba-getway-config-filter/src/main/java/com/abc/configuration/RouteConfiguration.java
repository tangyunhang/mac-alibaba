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
    //Path配置路由规则： 可以配置多个路径的拦截规则, 添加前缀 过滤器
    @Bean
    public RouteLocator someRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(ps -> ps.path("/**")
                        .filters (fs -> fs.prefixPath("/producer"))
                        .uri("lb://msc-alibaba-producer")
                        .id("path_provider_route"))
                .route(ps -> ps.path("/api/gateway/consumer/**")
                        .filters (fs -> fs.stripPrefix (2))
                        .uri("lb://msc-alibaba-consumer")
                        .id("path_provider_route"))
                .build();
    }
}
