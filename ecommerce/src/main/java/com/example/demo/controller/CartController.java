package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Cart;
import com.example.demo.repository.CartRepository;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartRepository repo;

    @PostMapping("/add")
    public Cart addToCart(@RequestBody Cart cart) {
        return repo.save(cart);
    }

    @GetMapping("/{userId}")
    public List<Cart> getCart(@PathVariable Long userId) {
        return repo.findByUserId(userId);
    }

    @DeleteMapping("/{id}")
    public String removeItem(@PathVariable Long id) {
        repo.deleteById(id);
        return "Item removed from cart";
    }
}