package com.softclub.entity;
import jakarta.persistence.*;
import lombok.*;

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
    @GeneratedValue
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

    public Product (long productId, String productName){
        this.productId = productId;
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
