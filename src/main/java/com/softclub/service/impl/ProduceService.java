package com.softclub.service.impl;

import com.softclub.dto.ItemData;
import com.softclub.entity.Product;

import java.util.List;

public interface ProduceService {

    long createProduct(Product product);

    void deleteProduct(long id);

    Product getProduct(long id);

    List<Product> getAll();

    Product addItems(long id, List<ItemData> items);
}
