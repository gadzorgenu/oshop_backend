package com.example.oshopbackend.services;

import com.example.oshopbackend.dao.OrderDao;
import com.example.oshopbackend.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderDao orderDao;

    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public Order createOrder(Order order){
        return orderDao.save(order);
    }
}
