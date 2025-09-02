package com.yassine.billingservice.repositories;

import com.yassine.billingservice.entities.ProductItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItemEntity,String> {
}
