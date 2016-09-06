package com.fedex.service.rate.crs;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJBHome;
import javax.naming.Context;
import javax.rmi.PortableRemoteObject;

import com.fedex.nxgen.common.util.DOMReplyHelper;
import com.fedex.nxgen.common.util.ExceptionUnwrapper;
import com.fedex.nxgen.common.util.ParseUtil;
import com.fedex.nxgen.ngl.v2.ientities.NglInterface;
import com.fedex.nxgen.servicefactory.v2.ServiceFactoryConstants;
import com.fedex.nxgen.servicefactory.v2.ServiceFactoryException;
import com.fedex.nxgen.servicefactory.v2.enterprise.ProxyHandler;
import com.fedex.service.rate.config.ConfigReader;

public class RemoteProxyHandler extends ProxyHandler implements InvocationHandler {
			private static Map m_homeCache;
			protected String m_calledServiceAppId = null;
/*     */   
/*  83 */   protected String m_authNImplementation = null;
/*  88 */   protected String m_securityPropFile = null;
/*  89 */   protected String m_clientPropFile = null;
/*  92 */   protected Class[] m_paramString = { String.class };
          	protected ServiceFactoryAuthenticationProvider m_secHelper = null;
/*  93 */   protected Class[] m_getterParams = { null };
/*     */   public RemoteProxyHandler(Class interfaceClass, String url, String jndiName, NglInterface logger, int maxConnectCount, int maxInvokeCount, ConfigReader configreader)
/*     */		throws ServiceFactoryException {
/*   74*/		super(interfaceClass, jndiName, logger);
/*   75*/		logMethodEntry(UQCN, UQCN, "super() complete");
/*   76*/		this.m_clusterURLs = url;
/*   77*/		this.m_url = null;
/*   78*/		this.m_maxConnectCount = maxConnectCount;
/*   79*/		this.m_maxInvokeCount = maxInvokeCount;
/*   80*/		this.m_interfaceName = this.m_interfaceClass.getName();
/*   81*/		this.m_clusterUseType = configreader.getProperties("cluster.use.type").trim();
/*   83*/		this.m_calledServiceAppId =  configreader.getProperties("remote.app.id");
/*   84*/		this.m_authNImplementation =  configreader.getProperties("token.impl.class");
/*   85*/		this.m_securityPropFile = null;
/*   86*/		this.m_clientPropFile = null;
/*     */     
/*   88*/		String clusterAutoReconnect = configreader.getProperties("cluster.auto.reconnect");
/*   89*/		if ((clusterAutoReconnect != null) && (clusterAutoReconnect.trim().length() > 0)) {
/*   91*/			if (ParseUtil.parseBoolean(clusterAutoReconnect)) {
/*   93*/         		this.m_clusterAutoReconnect = true;
/*   94*/         		this.m_clusterAutoTimeoutReconnect = true;
/*     */       	} else {
/*   98*/         		this.m_clusterAutoReconnect = false;
/*   99*/         		this.m_clusterAutoTimeoutReconnect = false;
/*     */       	}
/*     */     	} else {
/*  104*/       	this.m_clusterAutoReconnect = ParseUtil.parseBoolean(configreader.getProperties("cluster.auto.connection.reconnect"));
/*  105*/       	this.m_clusterAutoTimeoutReconnect = ParseUtil.parseBoolean(configreader.getProperties("cluster.auto.timeout.reconnect"));
/*     */     	}
/*  107*/     	this.m_errorThreshold = ParseUtil.parseInt(configreader.getProperties("service.timeout.threshold"));
/*  108*/     	this.m_timeoutIntervalMillis = ParseUtil.parseLong(configreader.getProperties("service.timeout.interval.msecs"));
/*  109*/     	this.m_resetIntervalMillis = ParseUtil.parseLong(configreader.getProperties("service.reset.interval.msecs"));
/*  110*/     	this.m_jndiRequestTimeoutMillis = ParseUtil.parseLong( Integer.toString(1000));
/*  111*/     	this.m_primaryLocation = getPrimaryLocation();
/*  112*/     	this.m_nbrOfClusterLocations = this.m_primaryLocation.nbrOfLocations;
/*  113*/    	 String serviceImpl =  "FAST".trim();
/*  114*/     	this.m_fastService = ("FAST".equalsIgnoreCase(serviceImpl));
/*  115*/     	this.m_connectionInfoSource = getSourceFromClassName(this.m_interfaceName);
/*  116*/     	multiClusterInit();  
/*     */ 
/*  119*/     	logMethodExit(UQCN, UQCN, toString());
/*     */   }

/*     */   public Object invoke(Object proxy, Method method, Object[] args)
/*     */     throws Throwable
/*     */   {
/*  139*/     logMethodEntry(UQCN, "invoke", null);
/*     */     
/*     */ 
/*     */ 
/*  143*/     Object savedBean = this.m_bean;
/*  144*/     String savedUrl = this.m_url;
/*  145*/     checkForReset();
/*  146*/     boolean resetToPrimary = (this.m_bean == null) && ("**RESET**".equals(this.m_url));
/*  147*/     if (this.m_bean == null) {
/*     */       try
/*     */       {
/*  150*/         multiClusterInit();
/*     */       }
/*     */       catch (ServiceFactoryException e)
/*     */       {
/*  159*/         if ((resetToPrimary) && (!this.m_clusterAutoReconnect))
/*     */         {
/*  161*/           this.m_bean = savedBean;
/*  162*/           this.m_url = savedUrl;
/*     */         }
/*     */         else
/*     */         {
/*  166*/           StringBuffer msg = new StringBuffer("Remote EJB method: ");
/*  167*/           msg.append(method.getName()).append(" not called. Unable to create the remote bean. Exception: ");
/*  168*/           msg.append(e.toString());
/*  169*/           msg.append(e.getRootCause() != null ? ". Cause: " + e.getRootCause().toString() : "");
/*  170*/           logMessage("FATAL", "9004", UQCN, "invoke", msg.toString(), null);
/*  171*/           if (this.m_fastService)
/*     */           {
/*  173*/             return singleNotificationReply(method, args, msg.toString(), "9004");
/*     */           }
/*     */           
/*  177*/           throw new RemoteException(msg.toString(), e.getException());
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  184*/     Throwable throwable = null;
/*  185*/     Object result = null;
/*     */     try
/*     */     {
/*  188*/       adjustInvokeCounter(1);
/*  189*/       result = invokeRemoteMethod(method, args);
/*  190*/       resetInvokeClusterRetryCount();
/*  191*/       if (method.getName().startsWith("checkDependencies")) {
/*  192*/         return addConnectionInfoNotification(method, result);
/*     */       }
/*      */       try
/*      */       {
/*  236 */         adjustInvokeCounter(-1);
/*  237 */         if (this.m_bean == null)
/*      */         {
/*  239 */           if ((this.m_nbrOfClusterLocations > 1) && (this.m_clusterAutoReconnect))
/*      */           {
/*  241 */             if (adjustInvokeClusterRetryCount() < this.m_nbrOfClusterLocations)
/*      */             {
/*  243 */               result = invoke(proxy, method, args);
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */       catch (ServiceFactoryException e) {}
/*  254 */       if (result != null) {
/*      */        return result;
/*      */       }
/*      */     }
/*      */     catch (ServiceFactoryException e)
/*      */     {
/*  197 */       logMessage("FATAL", "9005", UQCN, "invoke", e.getMessage(), null);
/*  198 */       if (this.m_fastService)
/*      */       {
/*  200 */         result = singleNotificationReply(method, args, e.getMessage(), "9005");
/*      */       }
/*      */       else
/*      */       {
/*  204 */         throwable = new RemoteException(e.getMessage());
/*      */       }
/*      */       
/*      */     }
/*      */     catch (Throwable t)
/*      */     {
/*  210 */       incrementAnError();
/*      */ 
/*  214 */       if (this.m_nbrOfClusterLocations > 1)
/*      */       {
/*  216 */         this.m_bean = null;
/*      */       }
/*  218 */      StringBuffer msg = new StringBuffer("Remote EJB method: ");
/*  219 */       msg.append(method.getName()).append(" called on interface: ");
/*  220 */       msg.append(this.m_interfaceClass.getName()).append(" failed. Cause: ");
/*      */       
/*  222 */       msg.append(t.getCause() != null ? t.getCause().toString() : t.toString());
/*  223 */       logMessage("FATAL", "9999", UQCN, "invoke", msg.toString(), null);
/*  224 */       if (this.m_fastService)
/*      */       {
/*  226 */         result = singleNotificationReply(method, args, msg.toString(), "9999");
/*      */       }
/*      */       else
/*      */       {
/*  230 */         throwable = t;
/*      */       }
/*      */     }
/*      */     finally
/*      */     {
/*      */       try {
/*  236 */         adjustInvokeCounter(-1);
/*  237 */         if (this.m_bean == null)
/*      */         {
/*  239 */           if ((this.m_nbrOfClusterLocations > 1) && (this.m_clusterAutoReconnect))
/*      */           {
/*  241 */             if (adjustInvokeClusterRetryCount() < this.m_nbrOfClusterLocations)
/*      */             {
/*  243 */               result = invoke(proxy, method, args);
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */       catch (ServiceFactoryException e) {}
/*      */     }
/*      */ 
/*  254 */     if ((throwable != null) && (!this.m_fastService))
/*      */     {
/*  256 */       throw ExceptionUnwrapper.unwrap(throwable); }
/*      */    
/*  259 */     return result;
/*      */   }
/*      */ 
/*      */   public String toString()
/*      */   {
/*  270 */     StringBuffer sbuf = new StringBuffer();
/*  271 */     String longName = getClass().getName();
/*  272 */     int lastDotPosition = longName.lastIndexOf('.');
/*  273 */     sbuf.append(longName.substring(lastDotPosition + 1)).append('{');
/*  274 */     sbuf.append("").append(super.toString());
/*  275 */     sbuf.append(", ").append("m_url").append(':').append(this.m_url);
/*  276 */     sbuf.append(", ").append("m_interfaceName").append(':').append(this.m_interfaceName);
/*  277 */     sbuf.append(", ").append("m_clusterURLs").append(':').append(this.m_clusterURLs);
/*  278 */     sbuf.append(", ").append("m_clusterUseType").append(':').append(this.m_clusterUseType);
/*  279 */     sbuf.append(", ").append("m_errorThreshold").append(':').append(this.m_errorThreshold);
/*  280 */     sbuf.append(", ").append("m_timeoutIntervalMillis").append(':').append(this.m_timeoutIntervalMillis);
/*  281 */     sbuf.append(", ").append("m_resetIntervalMillis").append(':').append(this.m_resetIntervalMillis);
/*  282 */     sbuf.append(", ").append("m_jndiRequestTimeoutMillis").append(':').append(this.m_jndiRequestTimeoutMillis);
/*  283 */     sbuf.append(", ").append("m_primaryLocation").append(':').append(this.m_primaryLocation);
/*  284 */     sbuf.append(", ").append("m_nbrOfClusterLocations").append(':').append(this.m_nbrOfClusterLocations);
/*  285 */     sbuf.append(", ").append("m_clusterAutoReconnect").append(':').append(this.m_clusterAutoReconnect);
/*  286 */     sbuf.append(", ").append("m_clusterAutoTimeoutReconnect").append(':').append(this.m_clusterAutoTimeoutReconnect);
/*  287 */     sbuf.append(", ").append("m_invokeClusterRetryCount").append(':').append(this.m_invokeClusterRetryCount);
/*  288 */     sbuf.append(", ").append("m_maxConnectCount").append(':').append(this.m_maxConnectCount);
/*  289 */     sbuf.append(", ").append("m_maxInvokeCount").append(':').append(this.m_maxInvokeCount);
/*  290 */     sbuf.append(", ").append("m_fastService").append(':').append(this.m_fastService);
/*  291 */     /*sbuf.append(", ").append("$interfaceConnectCountersMap").append(':').append(interfaceConnectCountersMap);
  292      sbuf.append(", ").append("$interfaceInvokeCountersMap").append(':').append(interfaceInvokeCountersMap);*/
/*  293 */     sbuf.append('}');
/*  294 */     return sbuf.toString();
/*      */   }
/*      */
/*      */   String getUrl()
/*      */   {
/*  305 */     return this.m_url;
/*      */   }
/*      */ 
/*      */   String getInterfaceName()
/*      */   {
/*  315 */     return this.m_interfaceName;
/*      */   }
/*      */ 
/*      */   String getClusterURLs()
/*      */   {
/*  325 */     return this.m_clusterURLs;
/*      */   }
/*      */ 
/*      */   String getClusterUseType()
/*      */   {
/*  335 */     return this.m_clusterUseType;
/*      */   }
/*      */ 
/*      */   int getErrorThreshold()
/*      */   {
/*  345 */     return this.m_errorThreshold;
/*      */   }
/*      */ 
/*      */   long getTimeoutIntervalMillis()
/*      */   {
/*  355 */     return this.m_timeoutIntervalMillis;
/*      */   }
/*      */ 
/*      */   long getResetIntervalMillis()
/*      */   {
/*  365 */     return this.m_resetIntervalMillis;
/*      */   }
/*      */ 
/*      */   long getJndiRequestTimeoutMillis()
/*      */   {
/*  375 */     return this.m_jndiRequestTimeoutMillis;
/*      */   }
/*      */ 
/*      */   int getNbrOfClusterLocations()
/*      */   {
/*  385 */     return this.m_nbrOfClusterLocations;
/*      */   }
/*      */ 
/*      */   int getMaxConnectCount()
/*      */   {
/*  395 */     return this.m_maxConnectCount;
/*      */   }
/*      */ 
/*      */   int getMaxInvokeCount()
/*      */   {
/*  405 */     return this.m_maxInvokeCount;
/*      */   }
/*      */ 
/*      */   boolean getClusterAutoReconnect()
/*      */   {
/*  415 */     return this.m_clusterAutoReconnect;
/*      */   }
/*      */ 
/*      */   int getInvokeClusterRetryCount()
/*      */   {
/*  425 */     return this.m_invokeClusterRetryCount;
/*      */   }
/*      */ 
/*      */   boolean getFastService()
/*      */   {
/*  435 */     return this.m_fastService;
/*      */   }
/*      */ 
/*      */   boolean getClusterAutoTimeoutReconnect()
/*      */   {
/*  445 */     return this.m_clusterAutoTimeoutReconnect;
/*      */   }
/*      */ 
/*      */   protected static EJBHome getHome(Context ctx, String jndiName)
/*      */     throws Exception
/*      */   {
/*  460 */     return getRemoteHome(ctx, jndiName, null);
/*      */   }
/*      */ 
/*      */   protected Object createBean(EJBHome home)
/*      */     throws ServiceFactoryException
/*      */   {
/*  476 */     logMethodEntry(UQCN, "createBean", null);
/*  477 */     Method method = null;
/*  478 */     Class homeClass = home.getClass();
/*      */     try
/*      */     {
/*  481 */       method = homeClass.getDeclaredMethod("create", new Class[0]);
/*  482 */       Object remoteObj = method.invoke(home, new Object[0]);
/*  483 */       logMethodExit(UQCN, "createBean", "returning remote object handle");
/*  484 */       return remoteObj;
/*      */     }
/*      */     catch (NoSuchMethodException e)
/*      */     {
/*  489 */       throw new ServiceFactoryException("Exception caught getting \"create\" method for class: " + homeClass.getName(), e);
/*      */     }
/*      */     catch (IllegalAccessException e)
/*      */     {
/*  493 */       throw new ServiceFactoryException("Exception invoking method: " + method != null ? method.getName() : "[null]", e);
/*      */     }
/*      */     catch (InvocationTargetException e)
/*      */     {
/*  497 */       remove(this.m_url, this.m_jndiName);
/*  498 */       throw new ServiceFactoryException("[null] Caused by: " + e.getCause(), e.getCause());
/*      */     }
/*      */   }
/*      */ 
/*      */  static void remove(String providerUrl, String jndiHomeName)
/*     */   {
/* 289 */     if ((providerUrl == null) || (jndiHomeName == null)) {
/* 290 */       return;
/*     */     }
/*     */     
/* 293 */     StringBuffer homeCacheKeyBuf = new StringBuffer(jndiHomeName);
/* 294 */     homeCacheKeyBuf.append("@").append(providerUrl);
/* 295 */     String homeCacheKey = homeCacheKeyBuf.toString();
/*     */     
/*     */ 
/* 298 */     if (m_homeCache.containsKey(homeCacheKey)) {
/* 299 */       m_homeCache.remove(homeCacheKey);
/*     */     }
/*     */   }
/*      */ 
/*      */   protected void adjustConnectCounter(int increment)
/*      */     throws ServiceFactoryException
/*      */   {
      		logMethodEntry(UQCN, "adjustConnectCounter", "increment=" + increment);
           
      synchronized (interfaceConnectCountersSyncObj)
           {
         InUseCounter iuc = (InUseCounter)interfaceConnectCountersMap.get(this.m_interfaceName);
             
       
       
         if (iuc == null)
             {
         iuc = new InUseCounter(this.m_interfaceName, this.m_maxConnectCount, increment < 0 ? 1 : increment);
           interfaceConnectCountersMap.put(this.m_interfaceName, iuc);
           logMethodExit(UQCN, "adjustConnectCounter", "added InUseCounter for '" + this.m_interfaceName + "'");
            return;
             }
             
          iuc.inUseCount = (iuc.inUseCount + increment < 0 ? 0 : iuc.inUseCount + increment);
             
         interfaceConnectCountersMap.put(this.m_interfaceName, iuc);
             
          if (iuc.inUseCount > iuc.maxUse)
             {
          throw new ServiceFactoryException("Service '" + this.m_interfaceName + "' is busy, max connect limit reached: " + iuc.maxUse);
             }
          StringBuffer result = new StringBuffer("updated InUseCounter for '").append(this.m_interfaceName);
         result.append("' to '").append(iuc.inUseCount).append("'");
          logMethodExit(UQCN, "adjustConnectCounter", result.toString());
           }
         }
/*      */ 
/*      */   protected void adjustInvokeCounter(int increment)
/*      */     throws ServiceFactoryException
/*      */   {
    logMethodEntry(UQCN, "adjustInvokeCounter", "increment=" + increment);
           
     synchronized (interfaceInvokeCountersSyncObj)
           {
          InUseCounter iuc = (InUseCounter)interfaceInvokeCountersMap.get(this.m_interfaceName);
             
       
         if (iuc == null)
             {
           iuc = new InUseCounter(this.m_interfaceName, this.m_maxInvokeCount, increment < 0 ? 1 : increment);
           interfaceInvokeCountersMap.put(this.m_interfaceName, iuc);
          logMethodExit(UQCN, "adjustInvokeCounter", "added InUseCounter for '" + this.m_interfaceName + "'");
          return;
             }
             
          iuc.inUseCount = (iuc.inUseCount + increment < 0 ? 0 : iuc.inUseCount + increment);
             
      interfaceInvokeCountersMap.put(this.m_interfaceName, iuc);
             
         if (iuc.inUseCount > iuc.maxUse)
             {
           throw new ServiceFactoryException("Service '" + this.m_interfaceName + "' is busy, max invoke limit reached: " + iuc.maxUse);
             }
        StringBuffer result = new StringBuffer("updated InUseCounter for '").append(this.m_interfaceName);
        result.append("' to '").append(iuc.inUseCount).append("'");
       logMethodExit(UQCN, "adjustInvokeCounter", result.toString());
           }
         }
/*      */ 
/*      */   protected void multiClusterInit()
/*      */     throws ServiceFactoryException
/*      */   {
/*  626 */     logMethodEntry(UQCN, "multiClusterInit", null);
/*      */     
/*  628 */     int nbrOfTries = this.m_nbrOfClusterLocations;
/*  629 */     if (!this.m_clusterAutoReconnect)
/*      */     {
/*  631 */       nbrOfTries = 1;
/*      */     }
/*  633 */     for (int i = 0; i < nbrOfTries; i++) {
/*      */       try
/*      */       {
/*  636 */         init();
/*      */ 
/*      */       }
/*      */       catch (ServiceFactoryException e)
/*      */       {
/*  641 */         if (this.m_nbrOfClusterLocations > 1)
/*      */         {
/*  643 */           this.m_primaryLocation.isUnavailable = true;
/*      */         }
/*  645 */         this.m_primaryLocation.firstErrorTime = System.currentTimeMillis();
/*  646 */         incrementAnError();
/*  647 */         if (i >= nbrOfTries - 1)
/*      */         {
/*  649 */           throw e;
/*      */         }
/*      */       }
/*      */     }
/*  653 */     logMethodExit(UQCN, "multiClusterInit", "OK");
/*      */   }
/*      */ 
/*      */   protected void init()
/*      */     throws ServiceFactoryException
/*      */   {
/*  671 */     logMethodEntry(UQCN, "init", null);
/*      */     
/*  673 */     Context ctx = null;
/*      */     try {
/*  675 */       this.m_url = getURLToUse();
/*  676 */       adjustConnectCounter(1);
/*      */       
/*  678 */       ctx = getInitialContext(this.m_url);
/*      */       
/*  683 */       if (this.m_jndiName.equalsIgnoreCase("EJB3")) {
/*  684 */         String ejb3LookupString = this.m_interfaceClass.getSimpleName() + "#" + this.m_interfaceClass.getName();
/*  685 */         this.m_bean = ctx.lookup(ejb3LookupString);
/*      */       }
/*      */       else {
/*  688 */         EJBHome home = getHome(ctx, this.m_jndiName);
/*      */         
/*  690 */         this.m_bean = createBean(home);
/*      */       }       
/*      */ 
/*  696 */       if ((null != this.m_authNImplementation) && 
/*  697 */         (null != this.m_calledServiceAppId)) {
/*      */         try {
/*  699 */           Class provider = Class.forName(this.m_authNImplementation.trim());
/*  700 */           if ((null != this.m_securityPropFile) && (null != this.m_clientPropFile)) {
/*  701 */             this.m_secHelper = ((ServiceFactoryAuthenticationProvider)provider.getConstructor(new Class[] { String.class, String.class }).newInstance(new Object[] { this.m_securityPropFile, this.m_clientPropFile }));
/*      */ 
/*      */           }
/*      */           else
/*      */           {
/*  706 */             this.m_secHelper = ((ServiceFactoryAuthenticationProvider)provider.newInstance());
/*      */           }
/*      */         } catch (Exception e) {
/*  709 */           logMessage("FATAL", "9009", UQCN, "init", "Caught Exception trying to create authN provider", e);
/*  710 */           throw new ServiceFactoryException(e);
/*      */         }
/*      */       }
/*      */       
/*  714 */       Method[] methods = this.m_bean.getClass().getMethods();
/*  715 */       for (int i = 0; i < methods.length; i++)
/*      */       {
/*  717 */         String key = getKey(methods[i]);
/*  718 */         this.m_availableMethods.put(key, methods[i]);
/*      */       }
/*      */       
/*  721 */       resetServiceLocationToAvailable(this.m_url);
/*      */ 
/*  733 */       adjustConnectCounter(-1);
/*      */       try {
/*  735 */         if (ctx != null)
/*      */         {
/*  737 */           ctx.close();
/*      */         }
/*      */       }
/*      */       catch (Exception ignore) {}
/*      */       
/*  742 */       logMethodExit(UQCN, "init", "Connected to '" + this.m_url + "'");
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  725 */       throw new ServiceFactoryException(e.getMessage(), e);
/*      */     }
/*      */   
/*      */     finally
/*      */     {
/*  733 */       adjustConnectCounter(-1);
/*      */       try {
/*  735 */         if (ctx != null)
/*      */         {
/*  737 */           ctx.close();
/*      */         }
/*      */       }
/*      */       catch (Exception ignore) {}
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */  public static String getKey(Method method)
/*    */   {
/* 44 */     if (method == null)
/*    */     {
/* 46 */       throw new IllegalArgumentException("null param: method");
/*    */     }
/* 48 */     StringBuffer key = new StringBuffer(0);
/* 49 */     key.append(method.getName()).append("(");
/* 50 */     Class[] parameters = method.getParameterTypes();
/* 51 */     for (int i = 0; i < parameters.length; i++)
/*    */     {
/* 53 */       key.append(parameters[i].getName()).append(",");
/*    */     }
/*    */     
/* 56 */     if (parameters.length > 0)
/*    */     {
/* 58 */       key.deleteCharAt(key.length() - 1);
/*    */     }
/* 60 */     key.append(")");
/* 61 */     return key.toString();
/*    */   }
/*      */ 
/*      */   protected ServiceLocation getPrimaryLocation()
/*      */   {
/*  762 */     logMethodEntry(UQCN, "getPrimaryLocation", null);
/*  763 */     ServiceLocation location = null;
/*  764 */     synchronized (serviceLocationsSyncObj)
/*      */     {
/*  766 */       ServiceLocations locations = (ServiceLocations)serviceLocationsMap.get(this.m_interfaceName);
/*  767 */       if (locations == null)
/*      */       {
/*      */ 
/*  770 */         locations = new ServiceLocations(this.m_interfaceName, this.m_clusterURLs, this.m_errorThreshold, this.m_timeoutIntervalMillis, this.m_resetIntervalMillis, this.m_clusterUseType);
/*      */       }
/*  772 */       location = locations.getPrimaryLocation();
/*  773 */       serviceLocationsMap.put(this.m_interfaceName, locations);
/*      */     }
/*  775 */     logMethodExit(UQCN, "getPrimaryLocation", "primary location: " + location.toString());
/*  776 */     return location;
/*      */   }
/*      */ 
/*      */   protected String getURLToUse()
/*      */   {
/*  789 */     logMethodEntry(UQCN, "getURLToUse", null);
/*  790 */     String url = "";
/*  791 */     if (this.m_clusterUseType.equalsIgnoreCase("NONE"))
/*      */     {
/*  793 */       if (this.m_clusterURLs.indexOf(",") > 0)
/*      */       {
/*  795 */         url = this.m_clusterURLs.substring(0, this.m_clusterURLs.indexOf(",")).trim();
/*      */       }
/*      */       else
/*      */       {
/*  799 */         url = this.m_clusterURLs.trim();
/*      */       }
/*  801 */       logMethodExit(UQCN, "getURLToUse", "URL to use is '" + url + "'");
/*  802 */       return url;
/*      */     }
/*  804 */     if (this.m_url == null)
/*      */     {
/*  806 */       logMessage("DEBUG", "dbg", UQCN, "getURLToUse", "First try using the primary URL '" + this.m_primaryLocation.url + "'", null);
/*      */       
/*  808 */       return this.m_primaryLocation.url;
/*      */     }
/*  810 */     if ("**RESET**".equals(this.m_url))
/*      */     {
/*  812 */       logMessage("DEBUG", "dbg", UQCN, "getURLToUse", "Reset URL to use back to primary URL '" + this.m_primaryLocation.url + "'", null);
/*      */       
/*  814 */       return this.m_primaryLocation.url;
/*      */     }
/*      */     
/*  817 */     synchronized (serviceLocationsSyncObj) {
/*  818 */       ServiceLocations locations = (ServiceLocations)serviceLocationsMap.get(this.m_interfaceName);
/*      */       
/*  820 */       if (locations == null)
/*      */       {
/*  822 */         locations = new ServiceLocations(this.m_interfaceName, this.m_clusterURLs, this.m_errorThreshold, this.m_timeoutIntervalMillis, this.m_resetIntervalMillis, this.m_clusterUseType);
/*      */       }
/*      */       
/*  825 */       url = locations.getURLToUse(this.m_url, this.m_primaryLocation);
/*  826 */       serviceLocationsMap.put(this.m_interfaceName, locations);
/*      */     }
/*  828 */     logMethodExit(UQCN, "getURLToUse", "URL to use '" + url + "'");
/*  829 */     return url;
/*      */   }
/*      */ 
/*      */   protected void incrementAnError()
/*      */   {
/*  844 */     logMethodEntry(UQCN, "incrementAnError", null);
/*      */     
/*  846 */     synchronized (serviceLocationsSyncObj) {
/*  847 */       ServiceLocations locations = (ServiceLocations)serviceLocationsMap.get(this.m_interfaceName);
/*      */       
/*  849 */       if (locations == null)
/*      */       {
/*  851 */         locations = new ServiceLocations(this.m_interfaceName, this.m_clusterURLs, this.m_errorThreshold, this.m_timeoutIntervalMillis, this.m_resetIntervalMillis, this.m_clusterUseType);
/*      */       }
/*      */       
/*  854 */       locations.incrementAnError(this.m_url, this.m_primaryLocation);
/*  855 */       serviceLocationsMap.put(this.m_interfaceName, locations);
/*      */     }
/*  857 */     logMethodExit(UQCN, "incrementAnError", null);
/*      */   }
/*      */ 
/*      */   protected void checkForReset()
/*      */   {
/*  871 */     logMethodEntry(UQCN, "checkForReset", null);
/*      */     
/*      */ 
/*  874 */     if (this.m_clusterUseType.equalsIgnoreCase("NONE"))
/*      */     {
/*  876 */       logMethodExit(UQCN, "checkForReset", "No location to reset, cluster use type is NONE");
/*  877 */       return;
/*      */     }
/*      */ 
/*  883 */     if ((!this.m_primaryLocation.isUnavailable) && (this.m_url.equals(this.m_primaryLocation.url)))
/*      */     {
/*  885 */       logMethodExit(UQCN, "checkForReset", "primary location is available");
/*  886 */       return;
/*      */     }   
/*      */ 
/*  890 */     long currentTime = System.currentTimeMillis();
/*  891 */     long timediff = currentTime - this.m_primaryLocation.firstErrorTime;
/*  892 */     if (timediff < this.m_primaryLocation.resetIntervalMillis)
/*      */     {
/*  894 */       logMethodExit(UQCN, "checkForReset", "Time diff (primary) ms '" + timediff + "' reset interval '" + this.m_primaryLocation.resetIntervalMillis + "' has not elapsed");
/*  895 */       return;
/*      */     }   
/*      */ 
/*  899 */     synchronized (serviceLocationsSyncObj)
/*      */     {
/*  901 */       ServiceLocations serviceLocations = (ServiceLocations)serviceLocationsMap.get(this.m_interfaceName);
/*      */       
/*  903 */       if (serviceLocations == null)
/*      */       {
/*  905 */         serviceLocations = new ServiceLocations(this.m_interfaceName, this.m_clusterURLs, this.m_errorThreshold, this.m_timeoutIntervalMillis, this.m_resetIntervalMillis, this.m_clusterUseType);
/*  906 */         serviceLocationsMap.put(this.m_interfaceName, serviceLocations);
/*      */       }
/*      */       
/*  909 */       ServiceLocation mapsVersionOfPrimary = null;
/*  910 */       int i = 0;
/*  911 */       for (i = 0; i < serviceLocations.locations.length; i++)
/*      */       {
/*  913 */         if (serviceLocations.locations[i].url.equals(this.m_primaryLocation.url))
/*      */         {
/*  915 */           mapsVersionOfPrimary = serviceLocations.locations[i];
/*  916 */           break;
/*      */         }
/*      */       }
/*  919 */       if (mapsVersionOfPrimary == null)
/*      */       {
/*  921 */         logMethodExit(UQCN, "checkForReset", "map primary location is null");
/*  922 */         return;
/*      */       }        
/*      */ 
/*  927 */       if (!mapsVersionOfPrimary.isUnavailable)
/*      */       {
/*  929 */         this.m_primaryLocation.firstErrorTime = mapsVersionOfPrimary.firstErrorTime;
/*  930 */         this.m_primaryLocation.errorCount = mapsVersionOfPrimary.errorCount;
/*  931 */         this.m_primaryLocation.isUnavailable = mapsVersionOfPrimary.isUnavailable;
/*      */          
/*  934 */         this.m_bean = null;
/*  935 */         this.m_url = "**RESET**";
/*  936 */         return;
/*      */       }
/*      */       
/*  939 */       timediff = currentTime - mapsVersionOfPrimary.firstErrorTime;
/*  940 */       logMethodExit(UQCN, "checkForReset", "Time diff (map) ms '" + timediff + "' reset interval '" + this.m_primaryLocation.resetIntervalMillis + "' has elapsed");
/*  941 */       if (timediff < mapsVersionOfPrimary.resetIntervalMillis)
/*      */       {
/*      */ 
/*  944 */         this.m_primaryLocation.firstErrorTime = mapsVersionOfPrimary.firstErrorTime;
/*  945 */         this.m_primaryLocation.errorCount = mapsVersionOfPrimary.errorCount;
/*  946 */         this.m_primaryLocation.isUnavailable = mapsVersionOfPrimary.isUnavailable;
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/*      */ 
/*  952 */         this.m_bean = null;
/*  953 */         this.m_url = "**RESET**";
/*      */       }
/*  955 */       logMethodExit(UQCN, "checkForReset", null);
/*      */     }
/*      */   }
/*      */ 
/*      */   protected void resetServiceLocationToAvailable(String url)
/*      */   {
/*  971 */     logMethodEntry(UQCN, "resetServiceLocationToAvailable", null);
/*      */     
/*      */ 
/*  974 */     synchronized (serviceLocationsSyncObj)
/*      */     {
/*  976 */       ServiceLocations serviceLocations = (ServiceLocations)serviceLocationsMap.get(this.m_interfaceName);
/*      */       
/*  978 */       if (serviceLocations == null)
/*      */       {
/*  980 */         serviceLocations = new ServiceLocations(this.m_interfaceName, this.m_clusterURLs, this.m_errorThreshold, this.m_timeoutIntervalMillis, this.m_resetIntervalMillis, this.m_clusterUseType);
/*  981 */         serviceLocationsMap.put(this.m_interfaceName, serviceLocations);
/*      */       }
/*      */       
/*  984 */       ServiceLocation location = null;
/*  985 */       int i = 0;
/*  986 */       for (i = 0; i < serviceLocations.locations.length; i++)
/*      */       {
/*  988 */         if (serviceLocations.locations[i].url.equals(url))
/*      */         {
/*  990 */           location = serviceLocations.locations[i];
/*  991 */           break;
/*      */         }
/*      */       }
/*  994 */       if (location == null)
/*      */       {
/*  996 */         return;
/*      */       }     
/*      */ 
/* 1000 */       location.firstErrorTime = 0L;
/* 1001 */       location.errorCount = 0;
/* 1002 */       location.isUnavailable = false;
/* 1003 */       serviceLocations.locations[i] = location;      
/*      */ 
/* 1006 */       if (this.m_primaryLocation.url.equals(url))
/*      */       {
/* 1008 */         this.m_primaryLocation.firstErrorTime = 0L;
/* 1009 */         this.m_primaryLocation.errorCount = 0;
/* 1010 */         this.m_primaryLocation.isUnavailable = false;
/*      */       }
/*      */       
/* 1013 */       serviceLocationsMap.put(this.m_interfaceName, serviceLocations);
/*      */     }
/* 1015 */     logMethodExit(UQCN, "resetServiceLocationToAvailable", "Location '" + url + "' reset!");
/*      */   }
/*      */ 
/*      */   protected int adjustInvokeClusterRetryCount()
/*      */   {
/* 1027 */     synchronized (invokeClusterRetryCountSyncObj) {
/* 1028 */       return ++this.m_invokeClusterRetryCount;
/*      */     }
/*      */   }
/*      */ 
/*      */   protected void resetInvokeClusterRetryCount()
/*      */   {
/* 1038 */     synchronized (invokeClusterRetryCountSyncObj) {
/* 1039 */       this.m_invokeClusterRetryCount = 0;
/*      */     }
/*      */   }  
/*      */ 
/*      */   protected Object addConnectionInfoNotification(Method method, Object reply)
/*      */   {
/* 1057 */     Object result = null;
/*      */     try {
/* 1059 */       DOMReplyHelper helper = new DOMReplyHelper(method);
/* 1060 */       Object locationInfoReply = helper.doCreateReplyWithSingleNotification("SUCCESS", this.m_connectionInfoSource, "0000", "Connected to '" + getUrl() + "' for service interface name '" + this.m_interfaceName + "'");
/*      */ 
/* 1065 */       List replies = new ArrayList();
/* 1066 */       replies.add(reply);
/* 1067 */       replies.add(locationInfoReply);
/* 1068 */       result = helper.doCreateReplyFromList(replies);
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1072 */       StringBuffer sb = new StringBuffer("Failed to add connection/location info Notification to reply Notification[]. Cause: ");
/* 1073 */       sb.append(e.toString());
/* 1074 */       logMessage("WARN", "9007", UQCN, "addConnectionInfoNotification", sb.toString(), null);
/*      */     }
/* 1076 */     return result != null ? result : reply;
/*      */   }
/*      */ 
/*      */   protected static String getSourceFromClassName(String name)
/*      */   {
/* 1094 */     String source = "prxy";
/*      */     try {
/* 1096 */       if (name.startsWith("com.fedex.nxgen.")) {
/* 1097 */         source = name.substring(FAST_COMMON_NAMESPACE_LENGTH);
/* 1098 */         int pos = 0;
/* 1099 */         if ((pos = source.indexOf(".v")) != -1) {
/* 1100 */           source = source.substring(0, pos);
/*      */         } else {
/* 1102 */           source = "prxy";
/*      */         }
/*      */       }
/*      */     }
/*      */     catch (Exception ignore) {}

/* 1109 */     return source;
/*      */   }
/*      */ 
/*      */   private void listCounterMap(Map whichMap, String mapName)
/*      */   {
/* 1123 */     logMethodEntry(UQCN, "listCounterMap", "Listing map '" + mapName + "'");
/* 1124 */     Set entryset = whichMap.entrySet();
/* 1125 */     Iterator i = entryset.iterator();
/* 1126 */     while (i.hasNext())
/*      */     {
/* 1128 */       Map.Entry e = (Map.Entry)i.next();
/* 1129 */       InUseCounter iuc = (InUseCounter)e.getValue();
/* 1130 */       logMessage("DEBUG", "dbg", UQCN, "listCounterMap", iuc.toString(), null);
/*      */     }
/* 1132 */     logMethodExit(UQCN, "listCounterMap", "Done listing map '" + mapName + "'");
/*      */   }
/*      */   public static String getUnqualifiedName(Class c)
/*    */   {
/* 39 */     String name = null;
/* 40 */     if (c != null) {
/* 41 */       name = c.getName();
/* 42 */       if (name.lastIndexOf('.') > 0)
/*    */       {
/* 44 */         name = name.substring(name.lastIndexOf('.') + 1);
/*    */       }
/*    */     }
/* 47 */     return name != null ? name : "";
/*    */   }
/*      */ 
/* 1137 */   private static final String UQCN = getUnqualifiedName(RemoteProxyHandler.class);
/*      */   private static final String FAST_COMMON_NAMESPACE = "com.fedex.nxgen.";
/* 1139 */   private static final int FAST_COMMON_NAMESPACE_LENGTH = "com.fedex.nxgen.".length();
/*      */   
/*      */   protected String m_url;
/*      */   private final String m_interfaceName;
/*      */   private final String m_clusterURLs;
/*      */   private final String m_clusterUseType;
/*      */   private final int m_errorThreshold;
/*      */   private final long m_timeoutIntervalMillis; 
/*      */   private final long m_resetIntervalMillis; 
/*      */   private final long m_jndiRequestTimeoutMillis;  
/*      */   private final ServiceLocation m_primaryLocation;
/* 1158 */   protected int m_nbrOfClusterLocations = 1;
/* 1159 */   protected static final Map interfaceConnectCountersMap = new HashMap();
/* 1160 */   protected static final Object interfaceConnectCountersSyncObj = new Object();
/*      */   protected int m_maxConnectCount;
/* 1162 */   protected static final Map interfaceInvokeCountersMap = new HashMap();
/* 1163 */   protected static final Object interfaceInvokeCountersSyncObj = new Object();
/*      */   protected int m_maxInvokeCount;
/* 1165 */   protected static final Map serviceLocationsMap = new HashMap();
/* 1166 */   protected static final Object serviceLocationsSyncObj = new Object();
/*      */   protected static final String RESET = "**RESET**";
/* 1168 */   protected boolean m_clusterAutoReconnect = false;
/* 1169 */   protected static final Object invokeClusterRetryCountSyncObj = new Object();
/* 1170 */   protected int m_invokeClusterRetryCount = 0;
/*      */   protected boolean m_fastService;
/*      */   protected boolean m_clusterAutoTimeoutReconnect;
/*      */   protected static final String CHECK_DEPENDENCIES = "checkDependencies";
/*      */   protected String m_connectionInfoSource;
/*      */ 
/*      */   class InUseCounter
/*      */   {
/*      */     String implName;
/*      */     int maxUse;
/*      */     int inUseCount;
/*      */     InUseCounter(String implName, int maxUse, int inUseCount)
/*      */     {
/* 1199 */       this.implName = implName;
/* 1200 */       this.maxUse = maxUse;
/* 1201 */       this.inUseCount = inUseCount;
/*      */     }
/*      */     public String toString()
/*      */     {
/* 1210 */       StringBuffer sb = new StringBuffer();
/* 1211 */       String longName = getClass().getName();
/* 1212 */       int lastDotPosition = longName.lastIndexOf('.');
/* 1213 */       sb.append(longName.substring(lastDotPosition + 1)).append('{');
/* 1214 */       sb.append("").append("implName").append(':').append(this.implName);
/* 1215 */       sb.append(", ").append("maxUse").append(':').append(this.maxUse);
/* 1216 */       sb.append(", ").append("inUseCount").append(':').append(this.inUseCount);
/* 1217 */       sb.append('}');
/* 1218 */       return sb.toString();
/*      */     }
/*      */   }
/*      */ 
/*      */   class ServiceLocations
/*      */   {
/*      */     RemoteProxyHandler.ServiceLocation[] locations;
/*      */ 
/*      */     String clusterUseType;
/*      */ 
/* 1239 */     int primaryIndx = 0;
/* 1240 */     int inUseEntryIndx = 0;
/* 1241 */     final String SL_UQCN = getUnqualifiedName(ServiceLocations.class);
/*      */ 
/*      */     ServiceLocations(String implName, String serviceURLs, int errorThreshold, long timeoutInterval, long resetInterval, String clusterUseType)
/*      */     {
/* 1258 */       String[] urls = serviceURLs.split(",");
/* 1259 */       this.locations = new RemoteProxyHandler.ServiceLocation[urls.length];
/* 1260 */       for (int i = 0; i < urls.length; i++)
/*      */       {
/* 1262 */         this.locations[i] = new RemoteProxyHandler.ServiceLocation( implName, urls[i], errorThreshold, timeoutInterval, resetInterval, urls.length);
/*      */       }
/* 1264 */       this.clusterUseType = clusterUseType;
/* 1265 */       this.primaryIndx = 0;
/* 1266 */       this.inUseEntryIndx = 0;
/*      */     }
/*      */     public RemoteProxyHandler.ServiceLocation getPrimaryLocation()
/*      */     {
/* 1282 */       RemoteProxyHandler.this.logMethodEntry(this.SL_UQCN, "getPrimaryLocation", null);
/*      */       
/* 1284 */       RemoteProxyHandler.ServiceLocation primary = this.locations[this.primaryIndx];
/*      */ 
/*      */ 
/* 1289 */       if ("RR".equalsIgnoreCase(this.clusterUseType))
/*      */       {
/* 1291 */         if (++this.primaryIndx > this.locations.length - 1)
/*      */         {
/* 1293 */           this.primaryIndx = 0;
/*      */         }
/*      */       }
/* 1296 */       RemoteProxyHandler.this.logMethodExit(this.SL_UQCN, "getPrimaryLocation", "updated primaryIndx=" + this.primaryIndx);
/* 1297 */       return primary;
/*      */     }
/*      */ 
/*      */     public String getURLToUse(String urlInUse, RemoteProxyHandler.ServiceLocation localPrimaryLocation)
/*      */     {
/* 1314 */       RemoteProxyHandler.this.logMethodEntry(this.SL_UQCN, "getURLToUse", "urlInUse '" + urlInUse + "' primary '" + localPrimaryLocation.toString() + "'");
/*      */       
/* 1316 */       String urlToUse = null;
/*      */ 
/* 1322 */       if ((urlInUse != null) && (!urlInUse.equals(localPrimaryLocation.url)))
/*      */       {
/* 1324 */         RemoteProxyHandler.ServiceLocation mapsVersionOfPrimary = null;
/* 1325 */         for (int i = 0; i < this.locations.length; i++)
/*      */         {
/* 1327 */           if (this.locations[i].url.equals(localPrimaryLocation.url))
/*      */           {
/* 1329 */             mapsVersionOfPrimary = this.locations[i];
/* 1330 */             break;
/*      */           }
/*      */         }
/* 1333 */         if (mapsVersionOfPrimary != null)
/*      */         {
/* 1335 */           if (!mapsVersionOfPrimary.isUnavailable)
/*      */           {
/* 1337 */             return mapsVersionOfPrimary.url;
/*      */           }
/*      */         }
/*      */       }
/* 1341 */       urlToUse = getNextURL();
/*      */       
/*      */ 
/* 1344 */       if (urlToUse == null)
/*      */       {
/*      */ 
/* 1347 */         if ((urlInUse != null) && (urlInUse.equals(localPrimaryLocation.url)))
/*      */         {
/* 1349 */           for (int i = 0; i < this.locations.length; i++)
/*      */           {
/* 1351 */             if (++this.inUseEntryIndx > this.locations.length - 1)
/*      */             {
/* 1353 */               this.inUseEntryIndx = 0;
/*      */             }
/* 1355 */             if (!this.locations[this.inUseEntryIndx].url.equals(urlInUse))
/*      */             {
/* 1357 */               RemoteProxyHandler.this.logMessage("DEBUG", "dbg", this.SL_UQCN, "getURLToUse", "Leaving: inUseEntryIndx=" + this.inUseEntryIndx, null);
/* 1358 */               return this.locations[this.inUseEntryIndx].url;
/*      */             }
/*      */           }
/*      */         }
/* 1362 */         urlToUse = localPrimaryLocation.url;
/* 1363 */         RemoteProxyHandler.this.logMessage("DEBUG", "dbg", this.SL_UQCN, "getURLToUse", "getNextURL returned null; using primary URL: " + localPrimaryLocation.url, null);
/*      */       }
/* 1365 */       RemoteProxyHandler.this.logMethodExit(this.SL_UQCN, "getURLToUse", null);
/* 1366 */       return urlToUse;
/*      */     }
/*      */ 
/*      */     private String getNextURL()
/*      */     {
/* 1379 */       RemoteProxyHandler.this.logMethodEntry(this.SL_UQCN, "getNextURL", null);
/* 1380 */       int maxAttempts = this.locations.length;
/* 1381 */       for (int i = 0; i < maxAttempts; i++)
/*      */       {
/* 1383 */         if (++this.inUseEntryIndx > this.locations.length - 1)
/*      */         {
/* 1385 */           this.inUseEntryIndx = 0;
/*      */         }
/* 1387 */         if (!this.locations[this.inUseEntryIndx].isUnavailable)
/*      */         {
/* 1389 */           RemoteProxyHandler.this.logMethodExit(this.SL_UQCN, "getNextURL", "inUseEntryIndx=" + this.inUseEntryIndx);
/* 1390 */           return this.locations[this.inUseEntryIndx].url;
/*      */         }
/*      */       }
/*      */       
/* 1394 */       RemoteProxyHandler.this.logMethodExit(this.SL_UQCN, "getNextURL", "all URLs unavailable - returning null");
/* 1395 */       return null;
/*      */     }
/*      */ 
/*      */     public void incrementAnError(String urlInUse, RemoteProxyHandler.ServiceLocation primaryLocation)
/*      */     {
/* 1416 */       RemoteProxyHandler.this.logMethodEntry(this.SL_UQCN, "incrementAnError", null);
/*      */       
/* 1419 */       if (this.locations.length < 2)
/*      */       {
/* 1421 */         RemoteProxyHandler.this.logMethodExit(this.SL_UQCN, "incrementAnError", "only one location so nothing to do");
/* 1422 */         return;
/*      */       }
/*      */       
/* 1425 */       RemoteProxyHandler.ServiceLocation mapsVersionOfUsed = null;
/* 1426 */       for (int i = 0; i < this.locations.length; i++)
/*      */       {
/* 1428 */         if (this.locations[i].url.equals(urlInUse))
/*      */         {
/* 1430 */           mapsVersionOfUsed = this.locations[i];
/* 1431 */           break;
/*      */         }
/*      */       }
/* 1434 */       if (mapsVersionOfUsed != null)
/*      */       {
/* 1436 */         if (++mapsVersionOfUsed.errorCount == 1)
/*      */         {
/* 1438 */           mapsVersionOfUsed.firstErrorTime = System.currentTimeMillis();
/*      */         }
/* 1440 */         if (mapsVersionOfUsed.errorCount > mapsVersionOfUsed.errorThreshold)
/*      */         {
/* 1442 */           mapsVersionOfUsed.isUnavailable = true;
/*      */         }
/*      */         
/* 1446 */         if (mapsVersionOfUsed.url.equals(primaryLocation.url))
/*      */         {
/* 1448 */           primaryLocation.firstErrorTime = mapsVersionOfUsed.firstErrorTime;
/* 1449 */           primaryLocation.errorCount = mapsVersionOfUsed.errorCount;
/* 1450 */           primaryLocation.isUnavailable = mapsVersionOfUsed.isUnavailable;
/*      */         }
/*      */       }
/*      */       
/* 1454 */       RemoteProxyHandler.this.logMethodExit(this.SL_UQCN, "incrementAnError", "ServiceLocation not found in map for '" + urlInUse + "'");
/*      */     }
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1465 */       StringBuffer sb = new StringBuffer();
/* 1466 */       String longName = getClass().getName();
/* 1467 */       int lastDotPosition = longName.lastIndexOf('.');
/* 1468 */       sb.append(longName.substring(lastDotPosition + 1)).append('{');
/* 1469 */       ServiceFactoryConstants.appendArray(sb, "", "locations", this.locations);
/* 1470 */       sb.append(", ").append("clusterUseType").append(':').append(this.clusterUseType);
/* 1471 */       sb.append(", ").append("primaryIndx").append(':').append(this.primaryIndx);
/* 1472 */       sb.append(", ").append("inUseEntryIndx").append(':').append(this.inUseEntryIndx);
/* 1473 */       sb.append('}');
/* 1474 */       return sb.toString();
/*      */     }
/*      */   }
/*      */   

public static EJBHome getRemoteHome(Context ctx, String jndiHomeName, Class homeClass)
/*     */     throws Exception
/*     */   {
/*     */     
/* 102 */    /* Args.checkForContent(jndiHomeName);
 103      Args.checkForNull(ctx);*/
/* 104 */     if (homeClass == null) {
/* 105 */       homeClass = EJBHome.class;
/*     */     }
/*     */     
/* 108 */     EJBHome home = null;
/* 109 */     Object objref = null;
/* 110 */     String providerUrl = "t3://crsvbase-wap.idev.fedex.com:7164";
/* 111 */     String key = "java.naming.provider.url";
/*     */     try {
/* 113 */       /*Hashtable env = ctx.getEnvironment();
 114        providerUrl = (String)env.get(key);*/
/*     */       
/*     */       m_homeCache=new HashMap();
/* 117 */       StringBuffer homeCacheKeyBuf = new StringBuffer(jndiHomeName);
/* 118 */       homeCacheKeyBuf.append("@").append(providerUrl);
/* 119 */       String homeCacheKey = homeCacheKeyBuf.toString();
/* 120 */       if (m_homeCache.containsKey(homeCacheKey)) {
/* 122 */         home = (EJBHome)m_homeCache.get(homeCacheKey);
/*     */       } else {
/* 124 */         objref = ctx.lookup(jndiHomeName);
/* 125 */         home = (EJBHome)narrow(objref, homeClass);
/* 126 */         m_homeCache.put(homeCacheKey, home);
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 130 */  
/* 131 */       throw new Exception("JNDI lookup failed for " + jndiHomeName + " due to a communication failure with WebLogic server at " + providerUrl, e);
/*     */     } 
/* 139 */     return home;
/*     */   }

private static Object narrow(Object objref, Class clazz)
/*     */   {
/* 348 */     return PortableRemoteObject.narrow(objref, clazz);
/*     */   }
/*      */ 
/*      */   class ServiceLocation
/*      */   {
/*      */     String implName;
/*      */     String url;
/*      */     boolean isUnavailable;
/*      */     int errorThreshold;
/*      */     long timeoutIntervalMillis;
/*      */     long resetIntervalMillis;
/*      */     int errorCount;
/*      */     long firstErrorTime;
/*      */     int nbrOfLocations;
/*      */     ServiceLocation(String implName, String url, int errorThreshold, long timeoutInterval, long resetInterval, int nbrOfServiceLocations)
/*      */     {
/* 1512 */       this.implName = implName;
/* 1513 */       this.url = url;
/* 1514 */       this.errorThreshold = errorThreshold;
/* 1515 */       this.timeoutIntervalMillis = timeoutInterval;
/* 1516 */       this.resetIntervalMillis = resetInterval;
/* 1517 */       this.isUnavailable = false;
/* 1518 */       this.errorCount = 0;
/* 1519 */       this.firstErrorTime = 0L;
/* 1520 */       this.nbrOfLocations = nbrOfServiceLocations;
/*      */     }
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1531 */       StringBuffer sb = new StringBuffer();
/* 1532 */       String longName = getClass().getName();
/* 1533 */       int lastDotPosition = longName.lastIndexOf('.');
/* 1534 */       sb.append(longName.substring(lastDotPosition + 1)).append('{');
/* 1535 */       sb.append("").append("implName").append(':').append(this.implName);
/* 1536 */       sb.append(", ").append("url").append(':').append(this.url);
/* 1537 */       sb.append(", ").append("errorThreshold").append(':').append(this.errorThreshold);
/* 1538 */       sb.append(", ").append("timeoutIntervalMillis").append(':').append(this.timeoutIntervalMillis);
/* 1539 */       sb.append(", ").append("resetIntervalMillis").append(':').append(this.resetIntervalMillis);
/* 1540 */       sb.append(", ").append("isUnavailable").append(':').append(this.isUnavailable);
/* 1541 */       sb.append(", ").append("errorCount").append(':').append(this.errorCount);
/* 1542 */       sb.append(", ").append("firstErrorTime").append(':').append(this.firstErrorTime);
/* 1543 */       sb.append(", ").append("nbrOfLocations").append(':').append(this.nbrOfLocations);
/* 1544 */       sb.append('}');
/* 1545 */       return sb.toString();
/*      */     }
/*      */   }
/*      */
 }
