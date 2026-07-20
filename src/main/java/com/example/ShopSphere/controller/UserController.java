package com.example.ShopSphere.controller;

import com.example.ShopSphere.model.request.RegisterUserRequest;
import com.example.ShopSphere.model.response.RegisterUserResponse;
import com.example.ShopSphere.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public RegisterUserResponse registerUser(@Valid @RequestBody RegisterUserRequest userDetails){
        log.info("Registering user");
        return userService.registerUser(userDetails);
    }


}
