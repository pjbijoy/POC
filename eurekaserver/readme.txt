Eureka Server project
Description: Once you startup this application, it will run as a eureka server
Components: 
1. pom.xml
	Dependency to parent (spring boot), eureka server, config , actuator, hystrix, hystrix dashboard, log4j (Excluded the default
	logger)
	compile using Java 1.8

2. bootstrap.yml
	Runs as eurekaserver, port 8761. 

bootstrap.yml example

spring:
    application:
        name: eurekaserver
    profiles:
        active: dev, test, prod
    cloud:
        config:
            uri: http://localhost:8888
            
server:
    port: 8761
    
eureka:
    client:
        registerWithEureka: false
        fetchRegistry: false
        server:
            waitTimeInMsWhenSyncEmpty: 0
        healthcheck:
            enabled: true

3. EurekaserverApplication.java
	Enabled spring boot and eureka server.
	@SpringBootApplication
	@EnableEurekaServer
	
4. banner.txt
	This will override the spring boot banner. You can create a new banner using following link http://patorjk.com/software/taag/#p=display&f=Graffiti&t=

5. log4j2.xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration monitorInterval="30" status="INFO">
  <Appenders>
    <Console name="Console" target="SYSTEM_OUT">
      <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
    </Console>
  </Appenders>
  <Loggers>
    <Logger name="com.fedex.bookstoreclient" level="INFO" additivity="false">
      <AppenderRef ref="Console"/>
    </Logger>
    <Root level="ERROR">
      <AppenderRef ref="Console"/>
    </Root>
  </Loggers>
</Configuration>

Startup command:
spring-boot:run
-Dlog4j.configurationFile=/Users/pjbijoy/conf/<application directory>/log4j2.xml -Dspring.profiles.active=dev

Useful URL's
http://localhost:8761/env - will give back environment information
http://localhost:8761/health - will give back health information
http://localhost:8761 - Will give back the UI which we can monitor the services registered.

