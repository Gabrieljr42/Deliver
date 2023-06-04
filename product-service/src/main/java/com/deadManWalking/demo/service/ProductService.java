package com.deadManWalking.demo.service;


import com.deadManWalking.demo.entity.Product;
import com.deadManWalking.demo.repository.ProductRepository;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    
 
}