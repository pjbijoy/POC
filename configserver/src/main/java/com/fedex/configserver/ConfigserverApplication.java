package com.fedex.configserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableAutoConfiguration
@EnableEurekaClient
public class ConfigserverApplication {
	static Logger logger = LoggerFactory.getLogger(ConfigserverApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConfigserverApplication.class, args);
		logger.info("Started Config Server Application");
	}
}
