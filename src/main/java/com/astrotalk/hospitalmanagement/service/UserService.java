package com.astrotalk.hospitalmanagement.service;

import com.astrotalk.hospitalmanagement.model.User;

public interface UserService {
    User saveUser(User user);
    Boolean isUserExists(String username);

    boolean checkUserByUserNameAndPassword(String username,String password);
}
