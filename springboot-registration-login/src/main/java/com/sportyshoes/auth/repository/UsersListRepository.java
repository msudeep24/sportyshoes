package com.sportyshoes.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportyshoes.auth.model.Product;
import com.sportyshoes.auth.model.User;
import com.sportyshoes.auth.model.Users;

public interface UsersListRepository extends JpaRepository<Users, Long> {
	List<Users> findAll();
}
