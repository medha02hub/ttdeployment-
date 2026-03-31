package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private double total;

    private String status;

    private LocalDate orderDate;

    public Orders(){}

    public Long getId() { return id; }

    public Long getUserId() { return userId; }

    public double getTotal() { return total; }

    public String getStatus() { return status; }

    public LocalDate getOrderDate() { return orderDate; }

    public void setId(Long id) { this.id = id; }

    public void setUserId(Long userId) { this.userId = userId; }

    public void setTotal(double total) { this.total = total; }

    public void setStatus(String status) { this.status = status; }

    public void setOrderDate(LocalDate orderDate) { this.orderDate = orderDate; }
}