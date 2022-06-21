package com.example.oshopbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data
//@Builder
@NoArgsConstructor
public class Cart {
    @Id
    private String id;
    private Integer quantity;
    private Product product;
    private BigDecimal totalPrice;

    public Cart(Integer quantity, Product product, BigDecimal totalPrice) {
        this.quantity = quantity;
        this.product = product;
        this.totalPrice = totalPrice;
    }
}
