package com.example.oshopbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
//@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private Integer quantity;
    private Product product;
    private BigDecimal totalPrice;

}
