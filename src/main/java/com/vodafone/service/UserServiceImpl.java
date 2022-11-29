package com.vodafone.service;

import com.vodafone.model.User;
import com.vodafone.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService{

    UserRepository userRepository;
    @Autowired

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void save(User user) {
        userRepository.saveUserToDb(user);
    }

    public List<User> findAll() {
        return userRepository.getUsers();
    }
}
