package com.fedex.service.rate.crs;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.fedex.nxgen.ngl.v2.ientities.NglInterface;
import com.fedex.nxgen.servicefactory.v2.ServiceFactoryException;

import com.fedex.service.rate.config.ConfigReader;

public class ServiceFactory {
/*     */   public static Object getServiceInstance(Class<?> interfaceClass, ConfigReader configreader) throws ServiceFactoryException {
/*  65 */   	String url = configreader.getProperties("ejb.url");
/*  66 */   	String jndiHomeName = configreader.getProperties("jndi.name");
/*  67 */   	String decoratorImpl = configreader.getProperties("fast.fail.impl");
/*     */     
/*  71 */   	String sMaxConnectCount = configreader.getProperties("max.concurrent.connect.attempts");
/*  72 */     	int maxConnectCount = 0;
/*  73 */		NglInterface logger = null;
/*     */ 
/*     */     	try {
/*  74 */       	maxConnectCount = Integer.parseInt(sMaxConnectCount);
/*     */     	} catch (NumberFormatException e)
/*     */     	{
/*  78 */       	throw new IllegalArgumentException("Required property 'max.concurrent.connect.attempts' is not numeric: " + sMaxConnectCount);
/*     */     	}
/*     */     
/*  81 */     	String sMaxInvokeCount = configreader.getProperties("max.concurrent.invoke.attempts");
/*  82 */     	int maxInvokeCount = 0;
/*     */     	try {
/*  84 */       	maxInvokeCount = Integer.parseInt(sMaxInvokeCount);
/*     */     	} catch (NumberFormatException e)
/*     */     	{
/*  88 */       	throw new IllegalArgumentException("Required property 'max.concurrent.invoke.attempts' is not numeric: " + sMaxInvokeCount);
/*     */     	}
/*     */     
/*  91 */     
/*  92 */     	InvocationHandler handler = null;
/*     */     	try {
/*  94 */       	if (decoratorImpl.equalsIgnoreCase("timeout")) {
/*  96 */         		handler = new RemoteProxyHandler(interfaceClass, url, jndiHomeName, logger, maxConnectCount, maxInvokeCount, configreader);
/*     */       	} else {
/* 100 */         		handler = new RemoteProxyHandler(interfaceClass, url, jndiHomeName, logger, maxConnectCount, maxInvokeCount, configreader);
/*     */       	}
/*     */
/* 102 */       	return Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[] { interfaceClass }, handler);
/*     */     	}
/*     */     	catch (IllegalArgumentException e) {
/* 107 */       	throw new ServiceFactoryException("Failed to create dynamic remote proxy for class: " + interfaceClass.getName(), e);
/*     */     	}
/*     */   }
}
/*     */   