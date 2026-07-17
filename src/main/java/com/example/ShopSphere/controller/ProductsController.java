package com.example.ShopSphere.controller;

import com.example.ShopSphere.model.entity.Product;
import com.example.ShopSphere.service.ProductsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    private ResponseEntity<Void> addProducts(@RequestBody List<Product> productList){
        log.info("Adding products");
        productsService.addProducts(productList);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    private void deleteProduct(@PathVariable int id){
        log.info("Delete a product");
        productsService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    private void updateProduct(@PathVariable int id, @RequestBody Product product){
        log.info("Update product");
        productsService.updateProduct(product, id);
    }


}
