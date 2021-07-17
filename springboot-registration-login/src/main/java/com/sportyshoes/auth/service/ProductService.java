package com.sportyshoes.auth.service;

import java.util.List;

import com.sportyshoes.auth.model.Product;
 
public interface ProductService {
 
    List<Product> findAll();
     
    void save(Product product);
     
    Product get(long id);
     
}