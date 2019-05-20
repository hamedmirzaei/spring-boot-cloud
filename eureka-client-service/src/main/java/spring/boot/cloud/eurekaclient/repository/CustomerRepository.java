package spring.boot.cloud.eurekaclient.repository;

import org.springframework.data.repository.CrudRepository;
import spring.boot.cloud.eurekaclient.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
