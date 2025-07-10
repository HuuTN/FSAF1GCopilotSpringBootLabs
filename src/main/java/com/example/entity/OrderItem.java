package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;

// A JPA entity for OrderItem with many-to-one relationships to Order and Product.
@Entity
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
    
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    
    private Integer quantity;
    private Double price; // Price at the time of order
}
