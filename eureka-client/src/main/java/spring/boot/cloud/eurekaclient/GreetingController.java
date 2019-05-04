package spring.boot.cloud.eurekaclient;

import org.springframework.web.bind.annotation.GetMapping;

public interface GreetingController {

    @GetMapping("/greeting")
    String greeting();

    @GetMapping("/hello")
    HelloObject getHelloWordObject();

}
