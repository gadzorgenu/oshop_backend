package com.example.oshopbackend.services;

import com.example.oshopbackend.dao.ProductDao;
import com.example.oshopbackend.entities.Product;
import com.example.oshopbackend.enums.Category;
import com.example.oshopbackend.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    ProductDao productDao;

    public Product createProduct(Product product){
        return productDao.save(product);
    }

    public Product updateProduct(String id,Product product) throws CustomException {
        var existingProduct = findById(id);

        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setImageUrl(product.getImageUrl());
        existingProduct.setCategory(product.getCategory());

        return productDao.save(existingProduct);
    }

    public Product findById(String id) throws CustomException {
        return productDao.findById(id).orElseThrow(() -> new CustomException("Product not found"));
    }

    public List<Product> getProduct(){
        return productDao.findAll();
    }

    public void deleteProduct(String id){
        productDao.deleteById(id);
    }

    public List<Product> getProductsByCategory(String category){
        return productDao.findAll(Category.valueOf(category.toUpperCase()));
    }

    public List<Category> getAllCategories(){
        return Arrays.stream(Category.values()).collect(Collectors.toList());
    }
}
