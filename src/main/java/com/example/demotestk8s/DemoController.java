package com.example.demotestk8s;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@ConfigurationPropertiesScan
class DemoController {

	private final CustomProperties properties;

	DemoController(CustomProperties properties) {
		this.properties = properties;
	}

	@GetMapping("/")
	public Mono<String> getData() {
		return Mono.just(properties.text());
	}
}

@ConfigurationProperties("messages")
record CustomProperties(String text) {}
