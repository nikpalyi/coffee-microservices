package com.np.coffeegateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("order-service", r -> r.path("/orders/**")
                        .uri("lb://coffee-order-service"))
                .route("inventory-service", r -> r.path("/inventory/**")
                        .uri("lb://coffee-inventory-service"))
                .build();
    }
}