package com.example.oshopbackend.services;

import com.example.oshopbackend.dao.ProductDao;
import com.example.oshopbackend.entities.Product;
import com.example.oshopbackend.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductDao productDao;

    public Product createProduct(Product product){
        return productDao.save(product);
    }

    public Product updateProduct(Product product) throws CustomException {
        var existingProduct = findProductByName(product.getName());

        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setImageUrl(product.getImageUrl());
        existingProduct.setCategory(product.getCategory());

        return productDao.save(existingProduct);
    }

    public Product findProductByName(String name) throws CustomException {
        return productDao.findPoductByName(name).orElseThrow(() -> new CustomException("Product not found"));
    }

    public List<Product> getProduct(){
        return productDao.findAll();
    }

    public void deleteProduct(Long id){
        productDao.deleteProduct(id);
    }
}
