package spring.boot.cloud.uifeignservice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.boot.cloud.uifeignservice.fallback.CustomerClientFallbackImpl;
import spring.boot.cloud.uifeignservice.model.Customer;

import java.util.List;

@FeignClient(value = "spring-cloud-eureka-client", fallback = CustomerClientFallbackImpl.class)
public interface CustomerController {

    @RequestMapping("/customers")
    ResponseEntity<List<Customer>> getAllCustomers();

}
