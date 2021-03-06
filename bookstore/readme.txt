Book Store server
Description: Once you startup this application, it will run as a book store server and serve the book store info
Components: 
1. pom.xml
	Dependency to parent (spring boot), config, eureka (to talk to discovery server), actuator, hystrix, hystrix dashboard, log4j (Excluded the default
	logger)
	compile using Java 1.8

2. bootstrap.yml
	Runs as bookstore, port 8090 and connect to config server running in the URI mentioned. 
		
bootstrap.yml example

spring:
    application:
        name: bookstore
        port: 8090
    profiles:
        active: dev, test, prod
    cloud:
        config:
            uri: http://localhost:8888

server:
    port: 8090

eureka:
    client:
        serviceUrl:
            defaultZone: http://localhost:8761/eureka/


3. BookstoreApplication.java
	Enabled spring boot, Rest controller, circuit breaker, hystrix dashboard, refresh scope and Eureka client.
	@SpringBootApplication
	@RestController
	@EnableCircuitBreaker
	@EnableHystrixDashboard
	@RefreshScope
	@EnableEurekaClient

	Give back the information to book store client. Logic can be set to sleep more time to test hystrix commands.
	
5. ConfigReader.java
	Enabled component and refresh scope
	@Component
	@RefreshScope	
	
	Reads properties using the key passed from the configuration server the application connected to.
		
6. banner.txt
	This will override the spring boot banner. You can create a new banner using following link http://patorjk.com/software/taag/#p=display&f=Graffiti&t=

7. log4j2.xml
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
http://localhost:8090/env - will give back environment information
http://localhost:8090/health - will give back health information
http://localhost:8080/recommended - will give back the response about recommended books

