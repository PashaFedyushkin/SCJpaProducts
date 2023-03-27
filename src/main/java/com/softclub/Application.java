package com.softclub;

import com.softclub.controller.ProductController;
import com.softclub.entity.Product;
import com.softclub.entity.ProductItem;
import com.softclub.repository.ProductItemRepository;
import com.softclub.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(ProductController productController) {

        return (args) -> {
            Product product1 = new Product(1, "Computer");
            Product product2 = new Product(2, "Monitor");
            long id1 = productController.addProduct(product1);
            long id2 = productController.addProduct(product2);
            List<Product> pr = productController.findAllProducts();
            for (Product p : pr){
                System.out.println(p);
            }
        };
    }
}
