package com.sportyshoes.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportyshoes.auth.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	List<Product> findAll();
}
