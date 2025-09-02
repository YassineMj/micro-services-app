package com.yassine.customerservice.services;

import com.yassine.customerservice.entities.CustomerEntity;
import com.yassine.customerservice.repositories.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }


    public ResponseEntity<List<CustomerEntity>> getAllCustomers() {
        return ResponseEntity.ok(repository.findAll());
    }

    public ResponseEntity<CustomerEntity> getCustomerById(String id) {
        Optional<CustomerEntity> customer = repository.findById(id);
        return customer.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<CustomerEntity> createCustomer(CustomerEntity customer) {
        return ResponseEntity.ok(repository.save(customer));
    }

    public ResponseEntity<CustomerEntity> updateCustomer(String id, CustomerEntity updated) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setUsername(updated.getUsername());
                    existing.setPassword(updated.getPassword());
                    return ResponseEntity.ok(repository.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Void> deleteCustomer(String id) {
        return repository.findById(id)
                .map(customer -> {
                    repository.delete(customer);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
