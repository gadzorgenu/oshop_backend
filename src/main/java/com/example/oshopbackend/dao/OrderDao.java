package com.example.oshopbackend.dao;

import com.example.oshopbackend.entities.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends MongoRepository<Order, String> {
    void createOrder(Order order);
}
