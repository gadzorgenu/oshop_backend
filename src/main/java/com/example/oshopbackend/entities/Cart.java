package com.example.oshopbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document("cart")
//@Builder
@NoArgsConstructor
public class Cart {
    @Id
    private String id;
    private Integer quantity;
    private String productId;
    private BigDecimal totalPrice;

    public Cart(Integer quantity, String productId, BigDecimal totalPrice) {
        this.quantity = quantity;
        this.productId = productId;
        this.totalPrice = totalPrice;
    }
}
