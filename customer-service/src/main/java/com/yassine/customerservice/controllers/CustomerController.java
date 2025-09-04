package com.yassine.customerservice.controllers;

import com.yassine.customerservice.entities.CustomerEntity;
import com.yassine.customerservice.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CustomerEntity>> getAll() {
        return service.getAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerEntity> getById(@PathVariable String id) {
        return service.getCustomerById(id);
    }

    @PostMapping
    public ResponseEntity<CustomerEntity> create(@RequestBody CustomerEntity customer) {
        return service.createCustomer(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerEntity> update(@PathVariable String id,
                                                 @RequestBody CustomerEntity customer) {
        return service.updateCustomer(id, customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return service.deleteCustomer(id);
    }


    @GetMapping("testTolerance")
    public String testCommunication(){
        return "Communication OK";
    }
}
