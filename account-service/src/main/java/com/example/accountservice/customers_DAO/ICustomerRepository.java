package com.example.accountservice.customers_DAO;

import com.example.accountservice.DTO.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="CUSTOMER-SERVICE")
public interface ICustomerRepository {

    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerCircuitBreaker", fallbackMethod = "getCustomerDefault")
    Customer findCustomerById(@PathVariable("id") Long id);

    default Customer getCustomerDefault(Long id, Exception e) {
        Customer customer= new Customer();
        customer.setEmail("not available");
        customer.setName("not available");
        customer.setId(id);
        return customer;
    }
}
