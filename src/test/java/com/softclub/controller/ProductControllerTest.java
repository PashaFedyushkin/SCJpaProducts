package com.softclub.controller;

import com.softclub.dto.ItemData;
import com.softclub.entity.Product;
import com.softclub.entity.ProductItem;
import com.softclub.repository.ProductRepository;
import com.softclub.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Autowired
    private ProductController productController;

    @Test
    public void addProductTest() {
        Product product = new Product("Computer");
        when(productService.createProduct(product)).thenReturn(1L);
        Assertions.assertEquals(1L, productController.addProduct(product));
    }

    @Test
    public void findProductByIdTest() {
        when(productService.getProduct(1L)).thenReturn(new Product(1L, "Computer", List.of()));
        Assertions.assertEquals("Computer", productController.findProductById(1L).getProductName());
    }

    @Test
    public void findAllProductsTest() {
        when(productService.getAll()).thenReturn(List.of(new Product("Computer"), new Product("Monitor")));
        Assertions.assertEquals(2, productController.findAllProducts().size());
    }


    @Test
    public void addItemsTest(){
        when(productService.addItems(1L, List.of(new ItemData(4), new ItemData(5))))
                .thenReturn(new Product(1L, "Computer", List.of(new ProductItem(4), new ProductItem(5))));
        Assertions.assertEquals(2, productController.addItems(1L, List.of(new ItemData(4), new ItemData(5))).getProductItems().size());
    }
}
