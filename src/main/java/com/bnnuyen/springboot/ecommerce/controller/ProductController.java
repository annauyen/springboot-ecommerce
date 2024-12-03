package com.bnnuyen.springboot.ecommerce.controller;

import com.bnnuyen.springboot.ecommerce.dao.ProductRepository;
import com.bnnuyen.springboot.ecommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product savedProduct = productRepository.save(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
}
