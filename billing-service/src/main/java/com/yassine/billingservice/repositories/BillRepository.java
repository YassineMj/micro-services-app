package com.yassine.billingservice.repositories;

import com.yassine.billingservice.entities.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<BillEntity,String> {
}
