package com.yassine.billingservice.feign;

import com.yassine.billingservice.models.ProductModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "inventory-service")
public interface ProductRestClient {

    @GetMapping("api/products/{id}")
    ProductModel getProductById(@PathVariable String id);

    @GetMapping("api/products")
    List<ProductModel> getAllProducts();
}
