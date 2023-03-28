package com.softclub.repository;

import com.softclub.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductName(String productName);

    @Query("""
        SELECT p
          FROM Product p
            LEFT JOIN FETCH p.productItems
         WHERE p.productId = :id
        """)
    Optional<Product> findByIdWithItems(long id);
}
