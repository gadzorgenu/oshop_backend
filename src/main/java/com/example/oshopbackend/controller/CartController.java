package com.example.oshopbackend.controller;

import com.example.oshopbackend.dto.ShoppingCart;
import com.example.oshopbackend.entities.Cart;
import com.example.oshopbackend.exceptions.CustomException;
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

    @PostMapping("/{productId}/{operation}")
    @ApiOperation(value = "Create shopping cart")
    public ResponseEntity<Cart> createCart(
            @ApiParam(value = "cart object")
            @PathVariable String productId,
            @PathVariable String operation

            ) throws CustomException {
        return new ResponseEntity<>(cartService.createCart(productId, operation), HttpStatus.CREATED);
    }


    @GetMapping("/")
    @ApiOperation(value = "Get items in cart")
    public ResponseEntity<List<Cart>> getItems() {
        return new ResponseEntity<>(cartService.getCarts(),HttpStatus.OK);
    }

    @DeleteMapping("/{cartId}")
    @ApiOperation(value = "Delete product in  shopping cart")
    public ResponseEntity<?> removeProduct(
            @ApiParam(value = "cart id")
            @PathVariable  String cartId
    ) throws CustomException {
        cartService.removeProduct(cartId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{cartId}")
    @ApiOperation(value = "Get product in  shopping cart")
    public ResponseEntity<Cart> getItem(
            @PathVariable  String cartId
    ) throws CustomException {
        return new ResponseEntity<>(cartService.getCart(cartId),HttpStatus.OK);
    }
    @GetMapping("/all")
    @ApiOperation(value = "Get entire shopping cart with total quantity")
    public ResponseEntity<ShoppingCart> getList( ){
        return new ResponseEntity<>(cartService.getList(),HttpStatus.OK);
    }

}
