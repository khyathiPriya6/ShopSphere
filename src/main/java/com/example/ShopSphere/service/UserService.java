package com.example.ShopSphere.service;

import com.example.ShopSphere.model.request.LoginUserRequest;
import com.example.ShopSphere.model.request.LogoutUserRequest;
import com.example.ShopSphere.model.request.RegisterUserRequest;
import com.example.ShopSphere.model.response.LoginUserResponse;
import com.example.ShopSphere.model.response.LogoutUserResponse;
import com.example.ShopSphere.model.response.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse registerUser(RegisterUserRequest userRequest);

    LoginUserResponse loginUser(LoginUserRequest loginUserRequest);

    LogoutUserResponse logout(LogoutUserRequest logoutUserRequest);
}
