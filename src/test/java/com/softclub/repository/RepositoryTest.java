package com.softclub.repository;

import com.softclub.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class RepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void findProductById() {
        assertEquals(1, productRepository.findById((long)1).get().getProductId());
        assertEquals(2, productRepository.findById((long)2).get().getProductId());
        assertEquals("Keyboard", productRepository.findById((long)3).get().getProductName());
        assertEquals("Mouse", productRepository.findById((long)4).get().getProductName());
    }

    @Test
    void findProductByName() {
        assertEquals(1, productRepository.findByProductName("Computer").size());
        assertEquals(1, productRepository.findByProductName("Monitor").size());
        assertEquals(1, productRepository.findByProductName("Keyboard").size());
        assertEquals(1, productRepository.findByProductName("Mouse").size());
    }

    @Test
    void findAll() {
        assertEquals(4, productRepository.findAll().size());
    }

    @Test
    void findProductItemsByProductId() {
        assertEquals(4, productRepository.findByIdWithItems(2).get().getProductItems().size());
    }

    @Test
    void addProduct (){
        Product p = new Product("Example1");
        long id1 = productRepository.save(p).getProductId();
        assertEquals(id1, productRepository.findById(id1).get().getProductId());
        productRepository.deleteById(id1);
    }

    @Test
    void deleteProduct(){
        Product p = new Product("Example2");
        long id1 = productRepository.save(p).getProductId();
        productRepository.deleteById(id1);
        assertEquals(0, productRepository.findByProductName("Example2").size());
    }
}
