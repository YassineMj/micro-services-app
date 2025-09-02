package com.yassine.billingservice;

import com.yassine.billingservice.entities.BillEntity;
import com.yassine.billingservice.entities.ProductItemEntity;
import com.yassine.billingservice.feign.CustomerRestClient;
import com.yassine.billingservice.feign.ProductRestClient;
import com.yassine.billingservice.models.CustomerModel;
import com.yassine.billingservice.models.ProductModel;
import com.yassine.billingservice.repositories.BillRepository;
import com.yassine.billingservice.repositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(BillRepository billRepository,
                                        ProductItemRepository productItemRepository,
                                        CustomerRestClient customerRestClient,
                                        ProductRestClient productRestClient){

        return args -> {
            Collection<CustomerModel> customers = customerRestClient.getAllCustomers();
            Collection<ProductModel> products = productRestClient.getAllProducts();

            customers.forEach(c->{
                System.out.println(c.getId());
            });

            products.forEach(p->{
                System.out.println(p.getId());
            });

            customers.forEach(customer -> {
                BillEntity bill = new BillEntity(new Date(),customer.getId());
                billRepository.save(bill);

                products.forEach(product -> {
                    ProductItemEntity productItem = new ProductItemEntity(product.getId(),bill,1+new Random().nextInt(10),product.getPrice());
                    productItemRepository.save(productItem);
                });
            });
        };
    }
}
