package com.softclub;

import com.softclub.controller.ProductController;
import com.softclub.dto.ItemData;
import com.softclub.entity.Product;
import com.softclub.entity.ProductItem;
import com.softclub.repository.ProductItemRepository;
import com.softclub.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(ProductController productController) {

        return (args) -> {
            Product product1 = new Product("Computer");
            Product product2 = new Product("Monitor");
            long id1 = productController.addProduct(product1);
            long id2 = productController.addProduct(product2);
            List<Product> pr = productController.findAllProducts();
            for (Product p : pr){
                System.out.println(p.getProductName());
            }
            List<ItemData> itemDataList = new ArrayList<>();
            itemDataList.add(new ItemData(10010323));
            itemDataList.add(new ItemData(10020323));
            itemDataList.add(new ItemData(10030323));
            itemDataList.add(new ItemData(10040323));
            productController.addItems(id1, itemDataList);
            productController.addItems(id2, itemDataList);
        };
    }
}
