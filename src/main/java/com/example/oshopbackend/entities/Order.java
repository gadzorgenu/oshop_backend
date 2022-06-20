package com.example.oshopbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Data
//@Builder
@Document
public class Order {
    @Id
    private String id;
    private Double price;
    private LocalDateTime created;
    private Cart cart;

    public Order(Double price,
                 LocalDateTime created,
                 Cart cart) {
        this.price = price;
        this.created = created;
        this.cart = cart;
    }
    //TODO: sum of items in the shopping cart

}
