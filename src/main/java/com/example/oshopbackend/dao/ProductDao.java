package com.example.oshopbackend.dao;

import com.example.oshopbackend.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductDao extends MongoRepository<Product, String> {
    public Product findPoductByName(String name);
}
