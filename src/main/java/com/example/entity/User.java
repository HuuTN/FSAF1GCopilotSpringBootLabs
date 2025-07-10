package com.example.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    private String email;
    
    // Add a bidirectional one-to-many relationship to the Order entity
    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Order> orders;
}
