package com.softclub.controller;

import com.softclub.dto.ItemData;
import com.softclub.entity.Product;
import com.softclub.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public long addProduct(Product product){
        return productService.createProduct(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeProduct(@PathVariable long id){
        productService.deleteProduct(id);
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable long id){
        return productService.getProduct(id);
    }

    @GetMapping
    public List<Product> findAllProducts(){
        return productService.getAll();
    }

    @PatchMapping("/{id}/items")
    public Product addItems(@PathVariable long id, @RequestBody List<ItemData> items) {
        return productService.addItems(id, items);
    }
}
