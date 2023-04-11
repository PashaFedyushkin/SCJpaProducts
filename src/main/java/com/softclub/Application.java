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

    /*@Bean
    public CommandLineRunner demo(ProductController productController) {

        return (args) -> {
            Product product1 = new Product("Computer");
            Product product2 = new Product("Monitor");
            Product product3 = new Product("Keyboard");
            Product product4 = new Product("Mouse");
            long id1 = productController.addProduct(product1);
            long id2 = productController.addProduct(product2);
            long id3 = productController.addProduct(product3);
            long id4 = productController.addProduct(product4);
            List<Product> pr = productController.findAllProducts();
            for (Product p : pr){
                System.out.println(p.getProductName());
            }
            List<ItemData> itemDataList1 = new ArrayList<>();
            itemDataList1.add(new ItemData(10010323));
            itemDataList1.add(new ItemData(10020323));
            itemDataList1.add(new ItemData(10030323));
            itemDataList1.add(new ItemData(10040323));
            productController.addItems(id1, itemDataList1);
            List<ItemData> itemDataList2 = new ArrayList<>();
            itemDataList2.add(new ItemData(10050323));
            itemDataList2.add(new ItemData(10060323));
            itemDataList2.add(new ItemData(10070323));
            itemDataList2.add(new ItemData(10080323));
            productController.addItems(id2, itemDataList2);
            List<ItemData> itemDataList3 = new ArrayList<>();
            itemDataList3.add(new ItemData(10090323));
            itemDataList3.add(new ItemData(10100323));
            itemDataList3.add(new ItemData(10110323));
            itemDataList3.add(new ItemData(10120323));
            productController.addItems(id3, itemDataList3);
            List<ItemData> itemDataList4 = new ArrayList<>();
            itemDataList4.add(new ItemData(10130323));
            itemDataList4.add(new ItemData(10140323));
            itemDataList4.add(new ItemData(10150323));
            itemDataList4.add(new ItemData(10160323));
            productController.addItems(id4, itemDataList4);

        };
    }*/
}
