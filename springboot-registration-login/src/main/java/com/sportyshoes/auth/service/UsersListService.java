package com.sportyshoes.auth.service;

import java.util.List;

import com.sportyshoes.auth.model.Users;

public interface UsersListService {
	 
     
    public void save(Users users);
     
    public Users get(long id);

	public List<Users> findAll();
     
    
}
