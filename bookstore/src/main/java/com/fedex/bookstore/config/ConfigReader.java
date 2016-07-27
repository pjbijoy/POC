package com.fedex.bookstore.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class ConfigReader {
	static Logger logger = LoggerFactory.getLogger(ConfigReader.class);
	@Autowired
	Environment env;

	public String getProperties(String key) {
		String value = env.getProperty(key);
		logger.info("Retreiving property from config server, Property key (" + key + "), Value (" + value + ")");
		
		return value;
	}
}
