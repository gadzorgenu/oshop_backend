package com.example.oshopbackend.dao;

import com.example.oshopbackend.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductDao extends MongoRepository<Product, String> {
     Product findPoductByName(String name);
     Optional<Product> findById(String Id);

     void createProduct(Product product);
}
