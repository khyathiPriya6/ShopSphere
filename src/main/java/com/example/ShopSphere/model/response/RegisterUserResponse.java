package com.example.ShopSphere.model.response;

import com.example.ShopSphere.model.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterUserResponse {
    private Integer userId;
    private String userName;
    private String email;
    private UserRole role;
}
