Config Server project
Description: Once you startup this application, it will run as a config server
Components: 
1. pom.xml
	Dependency to parent (spring boot), config server, eureka (to talk to discovery server), actuator, hystrix, hystrix dashboard, log4j (Excluded the default
	logger)
	compile using Java 1.8

2. bootstrap.yml
	Runs as configserver, port 8888 and connect to local git repository. 
	Make sure you run following git commands to create local repository
		- Download git
		- Create a folder, run "git init", 
		- Drop properties to the folder naming, bookstoreclient-dev.yml, bookstore-dev.yml
		- Run "git add <file name>"
		- Run "git commit -m "description""	
		
bootstrap.yml example

spring:
    application:
        name: configserver
    profiles:
        active: dev, test, prod
    cloud:
        config:
            server:
                git:
                    uri: /Users/pjbijoy/conf/config-repo/
server:
    port: 8888
    
eureka:
    client:
        serviceUrl:
            defaultZone: http://localhost:8761/eureka/


3. ConfigserverApplication.java
	Enabled spring boot, config server, auto configuration and Eureka client.
	@SpringBootApplication
	@EnableConfigServer
	@EnableAutoConfiguration
	@EnableEurekaClient 
	
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
http://localhost:8888/env - will give back environment information
http://localhost:8888/health - will give back health information
http://localhost:8888/bookstoreclient/dev - will give back bookstore-dev.yml file from the git (make sure this file is committed)

