package com.yassine.billingservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yassine.billingservice.models.ProductModel;
import jakarta.persistence.*;

@Entity
public class ProductItemEntity {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String productId;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private BillEntity bill;
    private int quantity;
    private double unitPrice;
    @Transient
    private ProductModel product;

    public ProductItemEntity(){}

    public ProductItemEntity(String productId, BillEntity bill, int quantity, double unitPrice) {
        this.productId = productId;
        this.bill = bill;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BillEntity getBill() {
        return bill;
    }

    public void setBill(BillEntity bill) {
        this.bill = bill;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }
}
