package com.softclub.service;

import com.softclub.dto.ItemData;
import com.softclub.entity.Product;

import java.util.List;

public interface ProductService {

    long createProduct(Product product);

    void deleteProduct(long id);

    Product getProduct(long id);

    List<Product> getAll();

    Product addItems(long id, List<ItemData> items);
}
