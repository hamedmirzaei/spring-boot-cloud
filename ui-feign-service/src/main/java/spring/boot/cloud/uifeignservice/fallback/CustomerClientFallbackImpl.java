package spring.boot.cloud.uifeignservice.fallback;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import spring.boot.cloud.uifeignservice.controller.CustomerController;
import spring.boot.cloud.uifeignservice.model.Customer;

import java.util.Arrays;
import java.util.List;

@Component
public class CustomerClientFallbackImpl implements CustomerController {

    @Override
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(Arrays.asList(new Customer(0L, 0L, "Unknown", "Unknown")));
    }
}
