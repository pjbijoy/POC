package com.fedex.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableCircuitBreaker
@EnableHystrixDashboard
@RefreshScope
@EnableEurekaClient
public class BookstoreApplication {
	static Logger logger = LoggerFactory.getLogger(BookstoreApplication.class);

	@RequestMapping(value = "/recommended")
	public String readingList() {
		logger.info("Providing reading list from service");
		try {
			//If setting this more than the limit set in command properties of client, client 
			//call will go to fall back
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 

		return "Cloud Native Java from service (O'Reilly)";
	}

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
		logger.info("Started Book Store Application");
	}
}
