package com.project.controllers;

import com.project.entities.ProductEntity;
import com.project.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductEntity>> findAllProducts(){
        return new ResponseEntity<List<ProductEntity>>( productService.getAllProducts(), HttpStatus.OK );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> getProductById(@PathVariable Integer id){
        return new ResponseEntity<ProductEntity>( productService.getById(id), HttpStatus.OK );
    }

    @PostMapping
    public ResponseEntity<ProductEntity> createProduct( @RequestBody ProductEntity product ){
        return new ResponseEntity<ProductEntity>( productService.createProduct( product ), HttpStatus.CREATED );
    }

}
