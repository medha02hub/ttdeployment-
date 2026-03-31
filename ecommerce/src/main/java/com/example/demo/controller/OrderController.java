package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Orders;
import com.example.demo.repository.OrderRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository repo;

    @PostMapping("/place")
    public Orders placeOrder(@RequestBody Orders order){

        order.setOrderDate(LocalDate.now());
        order.setStatus("PLACED");

        return repo.save(order);
    }

    @GetMapping("/{userId}")
    public List<Orders> getOrders(@PathVariable Long userId){
        return repo.findByUserId(userId);
    }
}