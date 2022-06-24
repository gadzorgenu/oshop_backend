package com.example.oshopbackend.controller;

import com.example.oshopbackend.entities.User;
import com.example.oshopbackend.exceptions.CustomException;
import com.example.oshopbackend.services.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping("/add")
    @ApiOperation("Add new user")
    public ResponseEntity<User> createUser(
            @ApiParam(value = "User details")
            @RequestBody User user){
        return new ResponseEntity<>(service.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @ApiOperation("Update user")
    public ResponseEntity<User> updateUser(
            @ApiParam(value = "New user details")
            @RequestBody User userUpdate) throws CustomException {
        return new ResponseEntity<>(service.updateUser(userUpdate), HttpStatus.OK);
    }
}
