package com.example.oshopbackend.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document("orderDetail")
public class OrderDetails {
    @Id
    private String id;
    private String orderId;
    private Integer quantity;
    private String productId;
    private BigDecimal totalPrice;

}
