package com.astrotalk.hospitalmanagement.service;

import com.astrotalk.hospitalmanagement.model.User;
import com.astrotalk.hospitalmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Boolean isUserExists(String username) {
        return userRepository.existsByUserName(username);
    }

    @Override
    public boolean checkUserByUserNameAndPassword(String username,String password) {
        return userRepository.existsUserByUserNameAndPassword(username,password);
    }
}
