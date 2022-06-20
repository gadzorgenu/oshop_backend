package com.example.oshopbackend.entities;

import com.example.oshopbackend.enums.CATEGORY;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
//@Builder
@Document
public class Product {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private BigDecimal price;
    private String imageUrl;
    private CATEGORY category;

    public Product(String name,
                   BigDecimal price,
                   String imageUrl,
                   CATEGORY category) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.category = category;
    }
}
