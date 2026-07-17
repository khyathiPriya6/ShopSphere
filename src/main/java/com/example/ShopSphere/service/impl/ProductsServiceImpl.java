package com.example.ShopSphere.service.impl;

import com.example.ShopSphere.model.entity.Product;
import com.example.ShopSphere.repository.ProductRepository;
import com.example.ShopSphere.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    @Override
    public void addProducts(List<Product> productsList){
        productRepository.saveAll(productsList);
    }
    @Override
    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }
    @Override
    public void updateProduct(Product product, int id){
        product.setProductId(id);
        productRepository.save(product);
    }
}
