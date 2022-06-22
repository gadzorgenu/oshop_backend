package com.example.oshopbackend.dao;

import com.example.oshopbackend.entities.Product;
import com.example.oshopbackend.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends MongoRepository<User, String> {
     Optional<User> findUserByEmail(String email);
}
