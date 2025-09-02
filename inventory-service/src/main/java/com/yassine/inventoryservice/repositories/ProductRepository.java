package com.yassine.inventoryservice.repositories;

import com.yassine.inventoryservice.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,String> {
}
