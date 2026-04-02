package com.ecommerce.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.backend.entity.Cart;
import com.ecommerce.backend.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/{userId}/add")
    public Cart addProduct(@PathVariable("userId") Long userId, @RequestBody Long productId) {
        return cartService.addProduct(userId, productId);
    }

    @PostMapping("/{userId}/remove")
    public Cart removeProduct(@PathVariable("userId") Long userId, @RequestBody Long productId) {
        return cartService.removeProduct(userId, productId);
    }

    @GetMapping("/{userId}")
    public Cart viewCart(@PathVariable("userId") Long userId) {
        return cartService.viewCart(userId);
    }}
