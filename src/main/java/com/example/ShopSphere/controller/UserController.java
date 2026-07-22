package com.example.ShopSphere.controller;

import com.example.ShopSphere.model.request.LoginUserRequest;
import com.example.ShopSphere.model.request.LogoutUserRequest;
import com.example.ShopSphere.model.request.RegisterUserRequest;
import com.example.ShopSphere.model.response.LoginUserResponse;
import com.example.ShopSphere.model.response.LogoutUserResponse;
import com.example.ShopSphere.model.response.RegisterUserResponse;
import com.example.ShopSphere.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/login")
    public LoginUserResponse login(@Valid @RequestBody LoginUserRequest loginRequest){
        log.info("User login");
        return userService.loginUser(loginRequest);
    }

    @GetMapping("/logout")
    public LogoutUserResponse logout(@Valid @RequestBody LogoutUserRequest logoutUserRequest){
        log.info("User logout");
        return userService.logout(logoutUserRequest);
    }

}
