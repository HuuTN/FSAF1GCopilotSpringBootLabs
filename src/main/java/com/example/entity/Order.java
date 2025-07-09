package com.example.entity;

import com.example.entity.base.Auditable;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

// A JPA entity for Order with a one-to-many relationship to OrderItem entities. The relationship should cascade all operations.
@Entity
@Table(name = "orders") // Using "orders" as "order" is a reserved word in SQL
@Data
public class Order extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderItem> items;
    
    private String orderNumber;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
}
