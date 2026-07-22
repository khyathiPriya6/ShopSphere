package com.example.ShopSphere.service.impl;

import com.example.ShopSphere.config.JwtService;
import com.example.ShopSphere.model.entity.Token;
import com.example.ShopSphere.model.entity.User;
import com.example.ShopSphere.model.enums.TokenType;
import com.example.ShopSphere.model.request.LoginUserRequest;
import com.example.ShopSphere.model.request.LogoutUserRequest;
import com.example.ShopSphere.model.request.RegisterUserRequest;
import com.example.ShopSphere.model.response.LoginUserResponse;
import com.example.ShopSphere.model.response.LogoutUserResponse;
import com.example.ShopSphere.model.response.RegisterUserResponse;
import com.example.ShopSphere.repository.TokenRepository;
import com.example.ShopSphere.repository.UserRepository;
import com.example.ShopSphere.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TokenRepository tokenRepository;

    @Autowired
    JwtService jwtService;

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
        String jwtToken = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);
        saveUserToken(user, jwtToken);
        return RegisterUserResponse.builder()
                .userId(user.getUserId())
                .userName(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public LoginUserResponse loginUser(LoginUserRequest loginUserRequest){
        User user = userRepository.findByEmail(loginUserRequest.getEmail());
        String accessToken = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, accessToken);
        return LoginUserResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public LogoutUserResponse logout(LogoutUserRequest logoutUserRequest){
        User user = userRepository.findByUserId(logoutUserRequest.getUserId());
        revokeAllUserTokens(user);
        String logOutSuccessMessage = "Logged out successfully";
        return LogoutUserResponse.builder().message(logOutSuccessMessage).build();
    }

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getUserId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }


}
