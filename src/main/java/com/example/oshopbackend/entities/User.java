package com.example.oshopbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
//@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("user")
public class User {
    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String email;
    private List<Address> address;
    private String city;
    private Boolean isAdmin;

    public User(String name, String email, List<Address> address, String city, Boolean isAdmin) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.city = city;
        this.isAdmin = isAdmin;
    }
}
