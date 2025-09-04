package com.yassine.billingservice.feign;

import com.yassine.billingservice.models.CustomerModel;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "customer-service")
public interface CustomerRestClient {

    @CircuitBreaker(name = "customerServiceCB", fallbackMethod = "getDefaultCustomer")
    @GetMapping("api/customers/{id}")
    CustomerModel getCustomerById(@PathVariable String id);
    default CustomerModel getDefaultCustomer(String id,Exception e){
        return new CustomerModel(id,"default Nom","default email");
    }

    @GetMapping("api/customers/testTolerance")
    @CircuitBreaker(name = "customerServiceCB", fallbackMethod = "getDefaultCommunication")
    String getStateCommunication();
    default String getDefaultCommunication(Exception e){
        return "Error";
    }

    @GetMapping("api/customers")
    List<CustomerModel> getAllCustomers();
}
