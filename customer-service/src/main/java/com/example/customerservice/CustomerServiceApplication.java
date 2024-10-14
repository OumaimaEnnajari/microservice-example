package com.example.customerservice;

import com.example.customerservice.entities.Customer;
import com.example.customerservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerServiceApplication implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;
    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        customerRepository.save(new Customer(1L,"OUMAIMA", "oumaima@gmail.com"));
//        customerRepository.save(new Customer(2L,"SOUMIA", "soumia@gmail.com"));

        /*==== we gonna use design pattern Builder to create some objects ====*/
        Customer customer1= Customer.builder()
                .id(1L)
                .name("OUMAIMA")
                .email("oumaima@gmail.com")
                .build();

        Customer customer2= Customer.builder()
                .id(2L)
                .name("SOUMIA")
                .email("soumia@gmail.com")
                .build();
        customerRepository.save(customer1);
        customerRepository.save(customer2);
    }
}
