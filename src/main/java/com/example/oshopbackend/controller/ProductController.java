package com.example.oshopbackend.controller;

import com.example.oshopbackend.entities.Product;
import com.example.oshopbackend.enums.CATEGORY;
import com.example.oshopbackend.exceptions.CustomException;
import com.example.oshopbackend.services.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping("/add")
    public ResponseEntity<Product> createProduct(
            @ApiParam(value = "product")
            @RequestBody Product product){
        return  new ResponseEntity<>(service.createProduct(product), HttpStatus.CREATED);
    }

    @GetMapping
    @ApiOperation(value = "Get all products")
    public ResponseEntity<List<Product>> getProduct(){
        return new ResponseEntity<>(service.getProduct(), HttpStatus.OK);
    }

//    @DeleteMapping("${id}")
//    @ApiOperation(value = "Delete Product")
//    public ResponseEntity<?> deleteProduct(
//            @ApiParam(value = "product id")
//            @PathVariable Long id){
//        service.deleteProduct(id);
//        return new ResponseEntity<>(HttpStatus.OK) ;
//    }

    @PutMapping("/update")
    @ApiOperation(value = "Update existing product")
    public ResponseEntity<Product> updateProduct(
            @ApiParam(value = "product")
            @RequestBody Product product) throws CustomException {
        return new ResponseEntity<>(service.updateProduct(product),HttpStatus.OK);
    }

    @GetMapping("/{category}")
    @ApiOperation(value = "Gets products under a category")
    public ResponseEntity<List<Product>> getProductsByCategory(
            @ApiParam(value = "product")
            @PathVariable CATEGORY category) {
        return new ResponseEntity<>(service.getProductsByCategory(category),HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CATEGORY>> getAllCategories(){
        var categories = Arrays.asList(CATEGORY.values());
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

}
