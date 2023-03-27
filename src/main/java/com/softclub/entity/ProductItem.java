package com.softclub.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "product_items")
public class ProductItem {
    @Id
    @GeneratedValue
    private Long itemId;
    private long inventoryNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductItem (long inventoryNumber){
        this.inventoryNumber = inventoryNumber;
    }
}