package com.yassine.billingservice.entities;

import com.yassine.billingservice.models.CustomerModel;
import jakarta.persistence.*;

import java.util.*;
import java.util.Date;

@Entity
public class BillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Date billingDate;
    private String customerId;
    @OneToMany(mappedBy = "bill")
    private List<ProductItemEntity> productItems = new ArrayList<>();
    @Transient private CustomerModel customer;

    public BillEntity(){}

    public BillEntity(Date billingDate, String customerId) {
        this.billingDate = billingDate;
        this.customerId = customerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(Date billingDate) {
        this.billingDate = billingDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<ProductItemEntity> getProductItems() {
        return productItems;
    }

    public void setProductItems(List<ProductItemEntity> productItems) {
        this.productItems = productItems;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }
}
