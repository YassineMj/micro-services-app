package com.yassine.customerservice;

import com.yassine.customerservice.entities.CustomerEntity;
import com.yassine.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner run(CustomerRepository repository) {
        return args -> {
            repository.save(new CustomerEntity("yassine", "pass123","yassine moujahid"));
            repository.save(new CustomerEntity("amine", "pass456","amine tirara"));
            repository.save(new CustomerEntity("sara", "secret789","sara mellouk"));
            repository.save(new CustomerEntity("karim", "admin000","karim marsli"));
            repository.save(new CustomerEntity("fatima", "pwd321","fatima mellouk"));
        };
    }
}
