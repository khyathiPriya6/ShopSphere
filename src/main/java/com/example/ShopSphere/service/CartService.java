package com.example.ShopSphere.service;


import com.example.ShopSphere.model.response.CartItemDetails;

import java.util.List;

public interface CartService {
    List<CartItemDetails> getCartItems(int userId);
}
