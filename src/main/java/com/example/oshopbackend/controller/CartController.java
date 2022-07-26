package com.example.oshopbackend.controller;

import com.example.oshopbackend.entities.Cart;
import com.example.oshopbackend.exceptions.CustomException;
import com.example.oshopbackend.requests.CartRequest;
import com.example.oshopbackend.services.CartService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/{operation}")
    @ApiOperation(value = "Create shopping cart")
    public ResponseEntity<Cart> createCart(
            @ApiParam(value = "cart object")
            @RequestBody CartRequest cart,
            @PathVariable String operation

            ) throws CustomException {
        return new ResponseEntity<>(cartService.createCart(cart, operation), HttpStatus.CREATED);
    }


    @GetMapping("/")
    @ApiOperation(value = "Get items in cart")
    public ResponseEntity<List<Cart>> getCart() {
        return new ResponseEntity<>(cartService.getCart(),HttpStatus.OK);
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
