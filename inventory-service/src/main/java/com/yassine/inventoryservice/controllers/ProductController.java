package com.yassine.inventoryservice.controllers;


import com.yassine.inventoryservice.entities.ProductEntity;
import com.yassine.inventoryservice.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProductEntity>> getAll() {
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> getById(@PathVariable String id) {
        return service.getProductById(id);
    }

    @PostMapping
    public ResponseEntity<ProductEntity> create(@RequestBody ProductEntity product) {
        return service.createProduct(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> update(@PathVariable String id,
                                                @RequestBody ProductEntity product) {
        return service.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return service.deleteProduct(id);
    }
}
