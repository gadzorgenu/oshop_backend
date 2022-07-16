package com.example.oshopbackend.controller;

import com.example.oshopbackend.entities.Cart;
import com.example.oshopbackend.services.CartService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/add")
    @ApiOperation(value = "Create shopping cart")
    public ResponseEntity<Cart> createCart(
            @ApiParam(value = "cart object")
            @RequestBody Cart cart
    ){
        return new ResponseEntity<>(cartService.createCart(cart), HttpStatus.CREATED);
    }
}
