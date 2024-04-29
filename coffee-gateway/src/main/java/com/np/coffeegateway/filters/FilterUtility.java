package com.np.coffeegateway.filters;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.http.HttpHeaders;
import java.util.List;

@Component
public class FilterUtility {

    public static final String CORRELATION_ID = "coffee-correlation-id";

    public String getCorrelationId(HttpHeaders requestHeaders) {
        return requestHeaders.get(CORRELATION_ID).stream().findFirst().orElse(null);
    }

    public ServerWebExchange setRequestHeader(ServerWebExchange exchange, String name, String value) {
        return exchange.mutate().request(exchange.getRequest().mutate().header(name, value).build()).build();
    }

    public ServerWebExchange setCorrelationId(ServerWebExchange exchange, String correlationId) {
        return this.setRequestHeader(exchange, CORRELATION_ID, correlationId);
    }
}
