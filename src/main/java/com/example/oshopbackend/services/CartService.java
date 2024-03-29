package com.example.oshopbackend.services;

import com.example.oshopbackend.dao.CartDao;
import com.example.oshopbackend.dao.ProductDao;
import com.example.oshopbackend.dto.ShoppingCart;
import com.example.oshopbackend.entities.Cart;
import com.example.oshopbackend.exceptions.CustomException;
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

    public Cart createCart(String productId, String operation) throws CustomException {
        var res = cartDao.findByProductId(productId);

        if(res.isEmpty()){
            var product = productDao.findById(productId)
                    .orElseThrow(() -> new CustomException("Product not found"));

            var newCart = Cart.builder()
                    .productId(productId)
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


    public List<Cart> getCarts(){
        return cartDao.findAll();
    }

    public void removeProduct(String cartId) throws CustomException {
        var cart = getCart(cartId);
         cartDao.deleteById(cart.getId());
    }

    public Cart getCart(String cartId) throws CustomException {
        return cartDao.findById(cartId).orElseThrow(() -> new CustomException("Cart not found"));
    }

    public ShoppingCart getList(){
        var items = getCarts();
        var totalQuantity = (Integer) items.stream().map(Cart::getQuantity).mapToInt(Integer::intValue).sum();

        return ShoppingCart
                .builder()
                .carts(items)
                .totalQuantity(totalQuantity)
                .build();
    }
}
