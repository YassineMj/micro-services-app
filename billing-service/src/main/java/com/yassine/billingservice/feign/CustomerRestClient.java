package com.yassine.billingservice.feign;

import com.yassine.billingservice.models.CustomerModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "customer-service")
public interface CustomerRestClient {

    @GetMapping("api/customers/{id}")
    CustomerModel getCustomerById(@PathVariable String id);

    @GetMapping("api/customers")
    List<CustomerModel> getAllCustomers();
}
