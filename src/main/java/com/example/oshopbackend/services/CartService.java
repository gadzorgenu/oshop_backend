package com.example.oshopbackend.services;

import com.example.oshopbackend.dao.CartDao;
import com.example.oshopbackend.entities.Cart;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final CartDao cartDao;

    public CartService(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    public Cart createCart(Cart cart){ return cartDao.save(cart);}
}
