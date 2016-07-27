package com.fedex.bookstoreclient.service;

import com.fedex.bookstoreclient.config.ConfigReader;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.*;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@EnableAutoConfiguration
@RefreshScope
@Service
public class BookService {
	static Logger logger = LoggerFactory.getLogger(BookService.class);
	@Autowired
	ConfigReader configreader;

	@Autowired
	private EurekaClient discoveryClient;
	
	@HystrixCommand(/*ignoreExceptions = {BadRequestException.class},*/ fallbackMethod = "fallBackCall", groupKey = "BookServiceGroupKey", commandKey = "BookServiceCommandKey", threadPoolKey = "BookServiceThreadPoolKey")
	public String readingList() {
		RestTemplate restTemplate = new RestTemplate();
		logger.info("Calling the service");

		String serviceUrl = getServiceUrl("BOOKSTORE");
		logger.info("Server URL connecting to ->" + serviceUrl);
		URI uri = URI.create(serviceUrl);

		return restTemplate.getForObject(uri, String.class);
	}

	/**
	 * Fall back method in case the service call failed
	 * @return
	 */
	public String fallBackCall() {
		logger.info("Processing call under fallBackCall");
		return "Cloud Native Java from fallback (O'Reilly)";
	}
	
	/**
	 * Provide service url back from the Eureka server
	 * @param serviceName
	 * @return
	 */
	public String getServiceUrl(String serviceName) {
		//String serviceURI = configreader.getProperties("bookstore.uri");
		InstanceInfo instance = discoveryClient.getNextServerFromEureka(serviceName, false);
		String serviceUrl = instance.getHomePageUrl();	
		
		return serviceUrl;
	}
}
