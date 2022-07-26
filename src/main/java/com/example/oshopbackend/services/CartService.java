package com.example.oshopbackend.services;

import com.example.oshopbackend.dao.CartDao;
import com.example.oshopbackend.dao.ProductDao;
import com.example.oshopbackend.entities.Cart;
import com.example.oshopbackend.exceptions.CustomException;
import com.example.oshopbackend.requests.CartRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CartService {
    private final ProductDao productDao;
    private final CartDao cartDao;

    public CartService(ProductDao productDao, CartDao cartDao) {
        this.productDao = productDao;
        this.cartDao = cartDao;
    }

    public Cart createCart(CartRequest cartRequest, String operation) throws CustomException {
        var res = cartDao.findByProductId(cartRequest.getProductId());

        if(res.isEmpty()){
            var product = productDao.findById(cartRequest.getProductId())
                    .orElseThrow(() -> new CustomException("Product not found"));

            var newCart = Cart.builder()
                    .productId(cartRequest.getProductId())
                    .product(product)
                    .quantity(1)
                    .createdAt(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                    .build();

            return  cartDao.save(newCart);
        }

        var newCart = res.get();
        var quantity = newCart.getQuantity();

        if(quantity > 1 && operation != null && operation.equals("remove")){
            newCart.setQuantity(quantity - 1);
            return cartDao.save(newCart);
        }

        newCart.setQuantity(quantity+1);
        return cartDao.save(newCart);
    }


    public List<Cart> getCart(){
        return cartDao.findAll();
    }

    public Cart getProductsInCart(String cartId, String productId) {
        return null;
    }
}
