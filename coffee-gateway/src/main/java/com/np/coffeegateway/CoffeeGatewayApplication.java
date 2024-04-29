package com.np.coffeegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

@EnableDiscoveryClient
@SpringBootApplication
public class CoffeeGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator coffeeRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/orders/**")
						.filters(f -> f.requestRateLimiter(rl -> {
							rl.setRateLimiter(redisRateLimiter());
							rl.setKeyResolver(userKeyResolver());
						}))
						.uri("lb://coffee-order-service"))
				.route(r -> r.path("/inventory/**")
						.uri("lb://coffee-inventory-service"))
				.build();
	}

	@Bean
	public RedisRateLimiter redisRateLimiter() {
		// You might need to adjust these numbers based on your application's needs
		return new RedisRateLimiter(5, 10);
	}

	@Bean
	public KeyResolver userKeyResolver() {
		return exchange -> Mono.justOrEmpty(exchange.getRequest().getHeaders().getFirst("user"))
				.defaultIfEmpty("anonymous");
	}
}

