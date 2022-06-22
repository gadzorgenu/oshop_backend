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
        if(user.getEmail().equals(existingUser.getEmail())){
            return userDao.save(user);
        }
        return existingUser;
    }

    public User findUserByEmail(String email) throws CustomException {
        return  userDao.findUserByEmail(email).orElseThrow(() -> new CustomException("User not found"));
    }
}
