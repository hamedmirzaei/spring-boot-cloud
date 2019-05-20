package spring.boot.cloud.eurekaclient.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import spring.boot.cloud.eurekaclient.model.Customer;

import java.util.List;

public interface CustomerController {

    @GetMapping("/customers")
    ResponseEntity<List<Customer>> getAllCustomers();

    @GetMapping("/customers/id/{cid}")
    ResponseEntity<Customer> getCustomer(@PathVariable("cid") Long customerId);

}
