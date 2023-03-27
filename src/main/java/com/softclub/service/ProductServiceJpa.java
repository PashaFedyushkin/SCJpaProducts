package com.softclub.service;


import com.softclub.dto.ItemData;
import com.softclub.entity.ProductItem;
import com.softclub.repository.ProductRepository;
import com.softclub.entity.Product;
import com.softclub.exception.ProductException;
import com.softclub.service.impl.ProduceService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceJpa implements ProduceService {

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
            .findById(id)
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
