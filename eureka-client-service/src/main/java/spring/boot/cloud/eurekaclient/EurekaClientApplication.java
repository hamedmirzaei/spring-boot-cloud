package spring.boot.cloud.eurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.cloud.eurekaclient.controller.CustomerController;
import spring.boot.cloud.eurekaclient.model.Customer;
import spring.boot.cloud.eurekaclient.service.CustomerService;

import java.util.List;

@RestController
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class EurekaClientApplication implements CustomerController {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

    @Autowired
    CustomerService customerService;

    @Override
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @Override
    public ResponseEntity<Customer> getCustomer(@PathVariable("cid") Long customerId) {
        return ResponseEntity.ok(customerService.getCustomer(customerId));
    }
}
