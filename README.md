# Spring Boot + Spring Cloud

This is a simple example to show you how Spring Cloud works with Spring Boot.

# Libraries and Tools
* [Module] [`Spring Boot`](https://spring.io/projects/spring-boot)
* [Module] [`Spring Cloud`](https://spring.io/projects/spring-cloud)
* [Module] `Spring Web`
* [Module] `Eureka Server/Client`
* [Library for auto-generating getters, setters, constructors and others] [`Lombok`](https://projectlombok.org/)
* [Library] `Thymeleaf`

# How it works
This is a simple demo to explain how `Spring Cload` works. In order to run it, you should first start 
`eureka-server` module which is the _Service Registry_ and other services need to be registered there 
(monitor it via [http://localhost:8765/](http://localhost:8765/)).

After that, start `eureka-client` which is a microservice in our example. It registered in `eureka-server` 
with id `spring-cloud-eureka-client` and serves the requests to `/hello` and `/greeting` address. 

Next, you should start the `ui-service` module. It will be start on port `8766` and registered in 
`eureka-server` with id `spring-cloud-ui-service`. It consumes the content provided by `eureka-client` 
using eureka discovery mechanism. Use [http://localhost:8766/](http://localhost:8766/) to see the result.

Another module is `ui-feign-service` which uses `Feign` and registered in `eureka-server` with id 
`spring-cloud-ui-feign-service`. Think of Feign as discovery-aware _Spring RestTemplate_ using 
interfaces to communicate with endpoints. This interfaces will be automatically implemented at 
runtime and instead of service-urls, it is using service-names. it will be start on port `8767` and 
consumes content provided by `eureka-client` on `/greeting` address. In case which `eureka-client` is down, it uses 
fallback mechanism and returns `Service is not available` message. 
Use [http://localhost:8767/](http://localhost:8767/get-greeting) to see the result.

