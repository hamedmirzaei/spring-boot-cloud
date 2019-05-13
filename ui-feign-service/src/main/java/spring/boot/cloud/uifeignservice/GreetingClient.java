package spring.boot.cloud.uifeignservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "spring-cloud-eureka-client", fallback = GreetingClientFallbackImpl.class)
public interface GreetingClient {

    @RequestMapping("/greeting")
    String greeting();

}
