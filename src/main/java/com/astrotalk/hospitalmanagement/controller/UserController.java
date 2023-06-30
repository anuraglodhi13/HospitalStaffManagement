package com.astrotalk.hospitalmanagement.controller;

import com.astrotalk.hospitalmanagement.constants.Constants;
import com.astrotalk.hospitalmanagement.model.User;
import com.astrotalk.hospitalmanagement.response.ResponseHandler;
import com.astrotalk.hospitalmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/hospital/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        try {
            if(!userService.isUserExists(user.getUserName())) {
                User savedUser = userService.saveUser(user);
                return ResponseHandler.generateResponse(Constants.SUCCESS_ADD_MESSAGE, HttpStatus.CREATED, savedUser);
            }
            return ResponseHandler.generateResponse(Constants.USER_ALREADY_PRESENT, HttpStatus.BAD_REQUEST, null);
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
            return ResponseHandler.generateResponse(Constants.CONFLICT_MESSAGE, HttpStatus.CONFLICT, null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Object> authenticateUser(@RequestBody User user) {
        try {
            if(userService.checkUserByUserNameAndPassword(user.getUserName(),user.getPassword())) {
                return ResponseHandler.generateResponse(Constants.LOGIN_MESSAGE, HttpStatus.OK, null);
            }
            return ResponseHandler.generateResponse(Constants.INVALID_CREDENTIALS, HttpStatus.BAD_REQUEST, null);
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
            return ResponseHandler.generateResponse(Constants.CONFLICT_MESSAGE, HttpStatus.CONFLICT, null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }


}
