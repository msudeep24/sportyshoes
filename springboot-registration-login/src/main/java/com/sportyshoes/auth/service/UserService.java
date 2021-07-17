package com.sportyshoes.auth.service;

import com.sportyshoes.auth.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
