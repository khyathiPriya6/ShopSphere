package com.example.ShopSphere.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDetails{
    private Integer productId;
    private String name;
    private BigDecimal price;
    private Boolean isAvailable;
}
