package com.fedex.bookstoreclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableCircuitBreaker
@EnableHystrixDashboard
@RefreshScope
@EnableEurekaClient
@EnableDiscoveryClient

public class BookstoreclientApplication {
	static Logger logger = LoggerFactory.getLogger(BookstoreclientApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreclientApplication.class, args);
		logger.info("Started Book Store Client Application");
	}
}
