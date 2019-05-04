# Spring Boot + Spting Cloud

This is a simple example to show you how Spring Cloud works with Spring Boot.

# Libraries and Tools
* [Module] `Spring Boot`
* [Module] `Spring Cloud`
* [Module] `Spring Web`
* [Module] `Eureka Server/Client`
* [Library for auto-generating getters, setters, constructors and others] `Lombok`
* [Library] `Thymeleaf`

# How it works
This is a simple demo to explain how `Spring Cload` works. In order to run it, you should first start `eureka-server` module which
is the _Service Registery_ and other services need to be registered there (monitor it via [http://localhost:8765/](http://localhost:8765/)).
After that, start `eureka-client` which is a microservice in our example. It registered in `eureka-server` with id 
`spring-cloud-eureka-client` and serves the requests to `/hello` address. Next, you should start the `ui-service` module. It will be
started on port `8766` and registerd in `eureka-server` with id `spring-cloud-ui-service` and consumes the content provided by the other service 
using eureka discovery mechanism. Use [http://localhost:8766/](http://localhost:8766/) to see the result.