package com.sportyshoes.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.auth.model.Users;
import com.sportyshoes.auth.repository.UsersListRepository;

@Service
public class UsersListServiceImpl implements UsersListService {
	@Autowired
    private UsersListRepository userRepository;
    
	@Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

	@Override
	public void save(Users users) {
		userRepository.save(users);
		
	}

	@Override
	public Users get(long id) {
		// TODO Auto-generated method stub
		 return userRepository.findById(id).get();
	}
}
