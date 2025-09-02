package com.yassine.billingservice.controllers;


import com.yassine.billingservice.entities.BillEntity;
import com.yassine.billingservice.feign.CustomerRestClient;
import com.yassine.billingservice.feign.ProductRestClient;
import com.yassine.billingservice.repositories.BillRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/billings")
public class BillingController {

    private final BillRepository billRepository;
    private final CustomerRestClient customerRestClient;
    private final ProductRestClient productRestClient;

    public BillingController(BillRepository billRepository, CustomerRestClient customerRestClient, ProductRestClient productRestClient) {
        this.billRepository = billRepository;
        this.customerRestClient = customerRestClient;
        this.productRestClient = productRestClient;
    }

    @GetMapping
    public ResponseEntity<List<BillEntity>> getAll(){

        List<BillEntity> billings=billRepository.findAll();
        billings.forEach(b->{
            b.setCustomer(customerRestClient.getCustomerById(b.getCustomerId()));

            b.getProductItems().forEach(p->{
                p.setProduct(productRestClient.getProductById(p.getProductId()));
            });
        });


        return ResponseEntity.ok(billings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillEntity> getById(@PathVariable String id){
        Optional<BillEntity> billEntity = billRepository.findById(id);
        billEntity.get().setCustomer(customerRestClient.getCustomerById(billEntity.get().getCustomerId()));

        billEntity.get().getProductItems().forEach(p->{
            p.setProduct(productRestClient.getProductById(p.getProductId()));
        });

        return billEntity.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
