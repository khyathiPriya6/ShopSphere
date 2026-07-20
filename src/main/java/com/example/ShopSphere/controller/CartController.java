package com.example.ShopSphere.controller;

import com.example.ShopSphere.model.entity.Product;
import com.example.ShopSphere.model.response.CartItemDetails;
import com.example.ShopSphere.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/{id}")
    public List<CartItemDetails> getCartItems(@PathVariable int id){
        log.info("Fetch cart items");
        return cartService.getCartItems(id);
    }
}
