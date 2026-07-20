package com.example.ShopSphere.service.impl;

import com.example.ShopSphere.model.entity.User;
import com.example.ShopSphere.model.request.RegisterUserRequest;
import com.example.ShopSphere.model.response.RegisterUserResponse;
import com.example.ShopSphere.repository.UserRepository;
import com.example.ShopSphere.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest userRequest){
        String hashedPassword = passwordEncoder.encode(userRequest.getPassword());
        User userDetails = User.builder()
                .username(userRequest.getUsername())
                .email(userRequest.getEmail())
                .passwordHash(hashedPassword)
                .phone(userRequest.getPhone())
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .phone(userRequest.getPhone())
                .role(userRequest.getRole())
                .build();
        User user = userRepository.save(userDetails);
        return RegisterUserResponse.builder()
                .userId(user.getUserId())
                .userName(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
