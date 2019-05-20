package spring.boot.cloud.eurekaclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.cloud.eurekaclient.model.Customer;
import spring.boot.cloud.eurekaclient.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<Customer>();
        customerRepository.findAll().forEach(e -> customers.add(e));
        return customers;
    }


    public Customer getCustomer(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            return customer.get();
        } else {
            return new Customer(0L, 0L, "Unknown", "Unknown");
        }
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

}
