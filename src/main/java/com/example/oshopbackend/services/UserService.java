package com.example.oshopbackend.services;

import com.example.oshopbackend.dao.UserDao;
import com.example.oshopbackend.entities.User;
import com.example.oshopbackend.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService  {
    @Autowired
    UserDao userDao;

    public User createUser(User user){
        return userDao.save(user);
    }

    public  User updateUser(User user) throws CustomException {
        var existingUser = findUserByEmail(user.getEmail());

        existingUser.setName(user.getName());
        existingUser.setCity(user.getCity());
        existingUser.setAddress(user.getAddress());
        existingUser.setEmail(user.getEmail());

        return userDao.save(existingUser);
    }

    public User findUserByEmail(String email) throws CustomException {
        return  userDao.findUserByEmail(email).orElseThrow(() -> new CustomException("User not found"));
    }
}
