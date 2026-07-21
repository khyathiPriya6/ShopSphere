package com.example.ShopSphere.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserRequest {

    @NotBlank(message = "Email is required")
    @Email(
            regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$",
            message = "Please provide a valid email address"
    )
    private String email;

    @NotBlank(message = "Password cannot be empty")
    private String password;
}
