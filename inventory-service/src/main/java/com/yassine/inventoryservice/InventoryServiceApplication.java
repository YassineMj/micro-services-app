package com.yassine.inventoryservice;

import com.yassine.inventoryservice.entities.ProductEntity;
import com.yassine.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ProductRepository repository) {
        return args -> {
            repository.save(new ProductEntity("Laptop", 1200.50, 10));
            repository.save(new ProductEntity("Smartphone", 750.00, 25));
            repository.save(new ProductEntity("Headphones", 150.99, 40));
            repository.save(new ProductEntity("Monitor", 300.00, 15));
        };
    }
}