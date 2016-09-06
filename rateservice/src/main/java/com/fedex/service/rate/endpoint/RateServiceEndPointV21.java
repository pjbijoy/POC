package com.fedex.service.rate.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.fedex.nxgen.crs.v15.ientities.CrsInterface;
import com.fedex.nxgen.crs.v15.ientities.RateReply;
import com.fedex.service.rate.config.ConfigReader;
import com.fedex.service.rate.crs.ServiceFactory;
import com.fedex.service.rate.mapper.RateRequestMappingV21;
import com.fedex.ws.rate.v21.RateRequest;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Endpoint
public class RateServiceEndPointV21 {
	private static final String NAMESPACE_URI = "http://fedex.com/ws/rate/v21";
	static Logger logger = LoggerFactory.getLogger(RateServiceEndPointV21.class);
	
	@Autowired
	ConfigReader configReader;

	CrsInterface serviceInterface = null;

	@Autowired
	private EurekaClient discoveryClient;

	@HystrixCommand(fallbackMethod = "getBooksFallBackCall", groupKey = "RateSoapWsGroupKey", commandKey = "RateSoapWsCommandKey", threadPoolKey = "RateSoapWsThreadPoolKey")
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "RateRequest")
	@ResponsePayload
	public RateReply getRateReply(@RequestPayload RateRequest rateRequest) {
		com.fedex.nxgen.crs.v15.ientities.RateRequest backEndRequest = new RateRequestMappingV21().getRateRequest(rateRequest);
		CrsInterface service = (CrsInterface) getService();
		com.fedex.nxgen.crs.v15.ientities.RateReply reply = service.getRates(backEndRequest);

		return reply;
	}

	private CrsInterface getService() {
		if (serviceInterface == null) {
			try {
				serviceInterface = (CrsInterface) ServiceFactory.getServiceInstance(CrsInterface.class, configReader);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return serviceInterface;
	}

	public RateReply fallBackCall(RateRequest rateRequest) {
		RateReply rateReply = new RateReply();
		rateReply.setHighestSeverity("ERROR");
		
		return rateReply;
	}

	/**
	 * Provide service url back from the Eureka server
	 * @param serviceName
	 * @return
	 */
	public String getServiceUrl(String serviceName) {
		InstanceInfo instance = discoveryClient.getNextServerFromEureka(serviceName, false);
		String serviceUrl = instance.getHomePageUrl();

		return serviceUrl;
	}
}
