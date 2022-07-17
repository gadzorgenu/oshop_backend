package com.example.oshopbackend.controller;

import com.example.oshopbackend.entities.Cart;
import com.example.oshopbackend.exceptions.CustomException;
import com.example.oshopbackend.services.CartService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{cartId}")
    @ApiOperation(value = "Get shopping cart by id")
    public ResponseEntity<Cart> getCart(@PathVariable  String cartId) throws CustomException {
        return new ResponseEntity<>(cartService.getCart(cartId),HttpStatus.OK);
    }

    @GetMapping("/{cartId}/items/{productId}")
    @ApiOperation(value = "Get product in a shopping cart")
    public ResponseEntity<Cart> getProductsInCart(
            @PathVariable  String cartId,
            @PathVariable String productId
    ) throws CustomException {
        return new ResponseEntity<>(cartService.getProductsInCart(cartId, productId),HttpStatus.OK);
    }
}
