package com.abc.configuration;

import com.abc.filter.AddHeaderGatewayFilter;
import com.abc.filter.OneGatewayFilter;
import com.abc.filter.ThreeGatewayFilter;
import com.abc.filter.TwoGatewayFilter;
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
    //Path配置路由规则： 调用自定义过滤器
    @Bean
    public RouteLocator someRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(ps -> ps.path("/showInfo/**")
                        .filters (fs->fs
                                    .filter (new AddHeaderGatewayFilter ())
                                    .filter (new OneGatewayFilter ())
                                    .filter (new TwoGatewayFilter ())
                                    .filter (new ThreeGatewayFilter ()))
                        .uri("lb://msc-alibaba-getway-showinfo")
                        .id("path_shoinfo_route_filter"))
                .build();
    }
}
