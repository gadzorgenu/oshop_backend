package com.example.oshopbackend.dao;

import com.example.oshopbackend.entities.Cart;
import com.example.oshopbackend.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface CartDao extends MongoRepository<Cart, String> {
    @Query(value = "{id: '?0'}")
    Optional<Cart> findById(String Id);
}
