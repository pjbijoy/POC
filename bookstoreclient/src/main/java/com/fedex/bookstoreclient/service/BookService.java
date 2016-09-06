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
	
	@HystrixCommand(/*ignoreExceptions = {BadRequestException.class},*/ fallbackMethod = "getBooksFallBackCall", groupKey = "BookServiceGroupKey", commandKey = "BookServiceCommandKey", threadPoolKey = "BookServiceThreadPoolKey")
	public String getBooksForBookName(String bookName) {
		/*try {
			//If setting this more than the limit set in command properties of client, client 
			//call will go to fall back
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} */
		
		logger.info("Calling the getBooks service");
		RestTemplate restTemplate = new RestTemplate();

		String serviceUrl = getServiceUrl("BOOKSTORE");
		logger.info("Server URL connecting to ->" + serviceUrl);
		URI uri = URI.create(serviceUrl + "books");
		if (bookName != null && bookName.trim().length() > 0) {
			
		}
		
		String response = restTemplate.getForObject(uri, String.class);

		return response;
	}

	/**
	 * Fall back method in case the service call failed
	 * @return
	 */
	public String getBooksFallBackCall() {
		logger.info("Processing call under getBooksFallBackCall");
		return "I am giving back response from getBooksFallBackCall()";
	}
	
	@HystrixCommand(/*ignoreExceptions = {BadRequestException.class},*/ fallbackMethod = "insertBooksFallBackCall", groupKey = "BookServiceGroupKey", commandKey = "BookServiceCommandKey", threadPoolKey = "BookServiceThreadPoolKey")
	public String insertBooks(Object object) {
		/*try {
			//If setting this more than the limit set in command properties of client, client 
			//call will go to fall back
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} */
		
		logger.info("Calling the insertBooks service");
		RestTemplate restTemplate = new RestTemplate();

		String serviceUrl = getServiceUrl("BOOKSTORE");
		logger.info("Server URL connecting to ->" + serviceUrl);
		URI uri = URI.create(serviceUrl + "books");
		String response = restTemplate.postForObject(uri, object, String.class);

		return response;
	}
	
	public String insertBooksFallBackCall() {
		logger.info("Processing call under insertBooksFallBackCall");
		return "I am giving back response from insertBooksFallBackCall()";
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
