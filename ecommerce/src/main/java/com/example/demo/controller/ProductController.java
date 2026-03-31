package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repo;

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return repo.save(product);
    }

    @GetMapping
    public List<Product> getProducts() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Object getProduct(@PathVariable Long id) {

        Optional<Product> product = repo.findById(id);

        if(product.isPresent()) {
            return product.get();
        }

        return "Product not found";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        repo.deleteById(id);
        return "Product deleted";
    }

    @GetMapping("/search")
    public List<Product> searchProduct(@RequestParam String keyword) {
        return repo.findByNameContainingIgnoreCase(keyword);
    }
}