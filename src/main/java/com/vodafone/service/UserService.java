package com.vodafone.service;

import com.vodafone.model.User;

import java.util.List;
public interface UserService {
    void save(User user);
    List<User> findAll();
}