package com.example.ShopSphere.repository;

import com.example.ShopSphere.model.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CartsRepository extends JpaRepository<Cart, Integer> {

    @Query("SELECT c.cartId from Cart c WHERE c.userId = :userId")
    Integer findCartIdFromUserId(Integer userId);
}
