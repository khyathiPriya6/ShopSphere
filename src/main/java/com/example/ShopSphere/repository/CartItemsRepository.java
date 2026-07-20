package com.example.ShopSphere.repository;

import com.example.ShopSphere.model.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemsRepository extends JpaRepository<CartItem, Integer> {

    List<CartItem> findAllCartItemsByCartId(Integer cartId);
}
