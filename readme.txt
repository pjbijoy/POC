Cloud native workspace
Description: This workspace contains multiple projects to demonstrate
1. Spring boot
2. Spring cloud
3. LOG4J2 and SLF4J
4. Hystrix
5. Eureka

Projects: 
1. eurekaserver
	Start up this first which will enable Eureka server

2. configserver
	Start this second, this server will register to the Eureka server so that other clients can discover 

3. bookstore
	Book store service which will give back the book info

4. bookstoreclient
	Publish the API interface for bookstore and talk to bookstore service to retrieve the information
	
