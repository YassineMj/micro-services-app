package com.yassine.inventoryservice.services;

import com.yassine.inventoryservice.entities.ProductEntity;
import com.yassine.inventoryservice.repositories.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        return ResponseEntity.ok(repository.findAll());
    }

    public ResponseEntity<ProductEntity> getProductById(String id) {
        Optional<ProductEntity> product = repository.findById(id);
        return product.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<ProductEntity> createProduct(ProductEntity product) {
        return ResponseEntity.ok(repository.save(product));
    }

    public ResponseEntity<ProductEntity> updateProduct(String id, ProductEntity updated) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setName(updated.getName());
                    existing.setPrice(updated.getPrice());
                    existing.setQuantity(updated.getQuantity());
                    return ResponseEntity.ok(repository.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Void> deleteProduct(String id) {
        return repository.findById(id)
                .map(product -> {
                    repository.delete(product);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
