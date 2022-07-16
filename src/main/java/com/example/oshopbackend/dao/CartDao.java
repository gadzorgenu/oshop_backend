package com.example.oshopbackend.dao;

import com.example.oshopbackend.entities.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartDao extends MongoRepository<Cart, String> {
}
