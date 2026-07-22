package com.example.ShopSphere.repository;

import com.example.ShopSphere.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    User findByUserId(Integer userId);
}
