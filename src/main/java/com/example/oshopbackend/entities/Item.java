package com.example.oshopbackend.entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Item {
    private String id;
    private Product product;
    private Integer quantity;

    public Item(String id, Product product, Integer quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public void setId() {
        this.id = product.getId();
    }
}
