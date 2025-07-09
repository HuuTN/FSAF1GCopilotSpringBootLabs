package com.example.entity;

import com.example.entity.base.Auditable;
import jakarta.persistence.*;
import lombok.Data;

// A JPA entity named Product with fields: id, name, price, stock. It has a many-to-one relationship with the Category entity.
@Entity
@Data
public class Product extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private Double price;
    private Integer stock;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
}
