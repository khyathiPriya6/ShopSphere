package com.example.ShopSphere.controller;

import com.example.ShopSphere.model.entity.Product;
import com.example.ShopSphere.service.ProductsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping
    public List<Product> getAllProducts(){
        log.info("Get All Products");
        return productsService.getAllProducts();
    }
}
