package com.example.oshopbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.swing.text.DateFormatter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
@Document("shopping-cart")
//@Builder
@NoArgsConstructor
public class Cart {
    @Id
    private String id;
    private String productId;

    private String createdAt;

    public Cart(String productId, LocalDate date) {
        this.productId = productId;
        this.createdAt = date.toString();
    }
}
