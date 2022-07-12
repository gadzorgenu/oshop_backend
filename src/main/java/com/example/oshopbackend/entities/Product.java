package com.example.oshopbackend.entities;

import com.example.oshopbackend.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
//@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("product")
public class Product {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private BigDecimal price;
    private String imageUrl;
    private Category category;

    public Product(String name,
                   BigDecimal price,
                   String imageUrl,
                   Category category) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.category = category;
    }
}
