package com.example.oshopbackend.services;

import com.example.oshopbackend.dao.OrderDao;
import com.example.oshopbackend.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderDao orderDao;

    public Order createOrder(Order order){
        return orderDao.save(order);
    }
}
