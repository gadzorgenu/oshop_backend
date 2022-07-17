package com.example.oshopbackend.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Document("shopping-cart")
//@Builder
@NoArgsConstructor
public class Cart {
    @Id
    private String id;
    private List<Item> items;
    private String createdAt;

    public Cart(LocalDate date) {
        this.createdAt = date.toString();
    }
    public Cart(LocalDate date, List<Item> items) {
        this.createdAt = date.toString();
        this.items = items;
    }
}
