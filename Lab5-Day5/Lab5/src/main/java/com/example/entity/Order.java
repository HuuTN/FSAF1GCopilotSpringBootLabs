// ...existing code...
// A JPA for Order with a one-to-many relationship to OrderItem entities. The relationship should casecade all operations.
package com.example.entity;
import jakarta.persistence.*;
import java.util.Set;
import java.time.LocalDateTime;

import com.example.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "orders")
// Removed Lombok annotations
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orderItems;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @Column(nullable = false)
    private String status;


    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", nullable = false)
    private OrderStatus orderStatus;


    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    public Order() {}

    public Order(Long id, Set<Order> orderItems, User user, String status, OrderStatus orderStatus, LocalDateTime orderDate) {
        this.id = id;
        this.orderItems = orderItems;
        this.user = user;
        this.status = status;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
    }
    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Order> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<Order> orderItems) {
        this.orderItems = orderItems;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}