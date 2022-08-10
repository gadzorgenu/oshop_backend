package com.example.oshopbackend.dto;

import com.example.oshopbackend.entities.Cart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShoppingCart {
    List<Cart> carts;
    Integer totalQuantity;
}
