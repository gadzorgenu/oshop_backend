package com.example.oshopbackend.dao;

import com.example.oshopbackend.entities.Product;
import com.example.oshopbackend.enums.CATEGORY;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductDao extends MongoRepository<Product, String> {
     @Query("{name: '?0'}")
     Optional<Product> findPoductByName(String name);

     @Query("{id: '?0'}")
     Optional<Product> findById(String Id);

//     We only want to project the product’s name in the query response, so we set those fields to 1.
     @Query(value = "{category: '?0'}", fields = "{'name': 1, 'price':1, 'imageUrl':1, 'category':1}")
     List<Product> findAll(CATEGORY category);

//     void deleteProduct(Long id);
}
