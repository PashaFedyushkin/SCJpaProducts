package com.softclub.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void findProductById() {
        long f = 3;
        assertEquals("Computer", productRepository.findById(f).get().getProductName());
    }

    @Test
    void findProductByName() {
        assertEquals(7, productRepository.findByProductName("Computer").size());
    }
}
