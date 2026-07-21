package com.example.ShopSphere.model.request;

import com.example.ShopSphere.model.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserRequest {

     @NotBlank(message = "Username cannot be empty")
     @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
     private String username;

     @NotBlank(message = "Email is required")
     @Email(
             regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$",
             message = "Please provide a valid email address"
     )
     private String email;

     @NotBlank(message = "Password cannot be empty")
     private String password;

     @NotBlank(message = "firstName cannot be empty")
     private String firstName;

     @NotBlank(message = "lastName cannot be empty")
     private String lastName;

     @NotBlank(message = "phone number cannot be empty")
     @Pattern(regexp = "^[0-9]{10}$", message= "Phone number should have 10 digits")
     private String phone;

    
     private UserRole role;

}
