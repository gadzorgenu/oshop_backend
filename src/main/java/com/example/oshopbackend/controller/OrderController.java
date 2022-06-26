package com.example.oshopbackend.controller;

import com.example.oshopbackend.entities.Order;
import com.example.oshopbackend.services.OrderService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<Order> createOrder(
        @ApiParam(value = "create order")
                @RequestBody Order order){
            return new ResponseEntity<>(orderService.createOrder(order), HttpStatus.CREATED);
        }
}
