package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.User;

import java.util.List;
public interface UserRepository extends JpaRepository<User, Long> {
    // Native query to join users and orders, grouping by order id
    @Query(value = "SELECT o.id AS orderId, u.id AS userId, u.name, u.email FROM orders o JOIN users u ON o.user_id = u.id GROUP BY o.id, u.id, u.name, u.email", nativeQuery = true)
    List<Object[]> findOrderUserDetailsGroupByOrderId();
}
