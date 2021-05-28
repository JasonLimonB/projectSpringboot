package com.project.services;

import com.project.entities.ProductEntity;
import com.project.respositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<ProductEntity> getAllProducts(){
        return  productRepository.findAll();
    }

    public  ProductEntity getById( Integer id ){
        Optional<ProductEntity> result = productRepository.findById(id);
        if( result.isPresent() )
            return result.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public ProductEntity createProduct( ProductEntity product ){
        return productRepository.save(product);
    }

}
