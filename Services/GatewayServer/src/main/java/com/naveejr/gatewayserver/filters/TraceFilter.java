package com.naveejr.gatewayserver.filters;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;


@RequiredArgsConstructor
@Slf4j

@Order(1)
@Component
public class TraceFilter implements GlobalFilter {

	private final FilterUtility filterUtil;

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		HttpHeaders requestHeaders = exchange.getRequest().getHeaders();
		String correlationId = filterUtil.getCorrelationId(requestHeaders);
		if (correlationId != null) {
			log.debug("Microbank Correlation ID found in tracing filter {}", correlationId);
		} else {
			correlationId = UUID.randomUUID().toString();
			exchange = filterUtil.setCorrelationId(exchange, correlationId);
			log.debug("Microbank Correlation ID generated in tracing filter {}", correlationId);
		}
		return chain.filter(exchange);
	}
}
