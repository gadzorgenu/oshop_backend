package com.example.oshopbackend.services;

import com.example.oshopbackend.dao.CartDao;
import com.example.oshopbackend.entities.Cart;
import com.example.oshopbackend.exceptions.CustomException;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final CartDao cartDao;

    public CartService(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    public Cart createCart(Cart cart){ return cartDao.save(cart);}

    public Cart getCart( String cartId) throws CustomException {
        return cartDao.findById(cartId).orElseThrow(() -> new CustomException("Cart not found"));
    }

    public Cart getProductsInCart(String cartId, String productId) {
        return new Cart();
    }
}
