package com.sportyshoes.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.auth.model.Product;
import com.sportyshoes.auth.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repo;
     
    @Override
    public List<Product> findAll() {
        return repo.findAll();
    }
     
    @Override
    public void save(Product product) {
        repo.save(product);
    }
     
    @Override
    public Product get(long id) {
        return repo.findById(id).get();
    }
     
}
