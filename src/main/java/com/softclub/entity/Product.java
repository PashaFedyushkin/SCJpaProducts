package com.softclub.entity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_seq")
    @SequenceGenerator(name = "products_seq", sequenceName = "products_seq", allocationSize = 1)
    private Long productId;
    private String productName;


    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ProductItem> productItems;

    public Product (String productName){
        this.productName = productName;
    }


    public void addProductItem (ProductItem productItem){
        productItems.add(productItem);
        productItem.setProduct(this);
    }

    public void removeProductItem (ProductItem productItem){
        productItems.remove(productItem);
        productItem.setProduct(null);
    }
}
