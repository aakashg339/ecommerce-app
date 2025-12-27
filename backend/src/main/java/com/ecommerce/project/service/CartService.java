package com.ecommerce.project.service;

import java.util.List;

import com.ecommerce.project.payload.CartDTO;

public interface CartService {

    CartDTO addProductToCart(Long productId, Integer quantity);

    List<CartDTO> getAllCarts();

}
