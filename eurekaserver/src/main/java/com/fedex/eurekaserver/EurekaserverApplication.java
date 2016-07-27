package com.fedex.eurekaserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaserverApplication {
	static Logger logger = LoggerFactory.getLogger(EurekaserverApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EurekaserverApplication.class, args);
		logger.info("Started Eureka Server Application");
	}
}
