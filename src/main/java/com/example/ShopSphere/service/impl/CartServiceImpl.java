package com.example.ShopSphere.service.impl;


import com.example.ShopSphere.model.entity.CartItem;
import com.example.ShopSphere.model.entity.Product;
import com.example.ShopSphere.model.response.CartItemDetails;
import com.example.ShopSphere.repository.CartItemsRepository;
import com.example.ShopSphere.repository.CartsRepository;
import com.example.ShopSphere.repository.ProductRepository;
import com.example.ShopSphere.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartsRepository cartsRepository;

    @Autowired
    CartItemsRepository cartItemsRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<CartItemDetails> getCartItems(int userId){
        Integer cartId = cartsRepository.findCartIdFromUserId(userId);
        List<CartItem> cartItems = cartItemsRepository.findAllCartItemsByCartId(cartId);
        List<Integer> productIds = cartItems.stream().map(CartItem ::getProductId).toList();
        List<Product> productList = productRepository.findAllById(productIds);
        List<CartItemDetails> cartItemDetailsList = productList.stream().map(product -> new CartItemDetails(product.getProductId(), product.getName(), product.getPrice(), product.getStockQuantity() ==0 ? Boolean.FALSE: Boolean.TRUE )).toList();
        return cartItemDetailsList;
    }
}
