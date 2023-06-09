package com.softclub.service.impl;


import com.softclub.dto.ItemData;
import com.softclub.entity.ProductItem;
import com.softclub.repository.ProductRepository;
import com.softclub.entity.Product;
import com.softclub.exception.ProductException;
import com.softclub.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProductServiceJpa implements ProductService {

    private ProductRepository repository;

    public long createProduct(Product product){
        return repository.save(product).getProductId();
    }

    public void deleteProduct(long id){
        repository.deleteById(id);
    }

    public Product getProduct(long id) {
        Optional<Product> p = repository.findById(id);
        if (p.isPresent()){
            return p.get();
        }
        throw new ProductException("Product not found", HttpStatus.NOT_FOUND);
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Product addItems(long id, List<ItemData> items) {
        return repository
            .findByIdWithItems(id)
            .map(p -> {
                items
                    .stream()
                    .map(ItemData::inventoryNumber)
                    .map(ProductItem::new)
                    .forEach(p::addProductItem);
                return repository.save(p);
            })
            .orElseThrow();
    }
}
