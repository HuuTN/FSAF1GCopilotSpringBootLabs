package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // JPQL query to search for products by keyword in name and max price, with pagination and sorting
    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) AND p.price <= :maxPrice")
    Page<Product> searchByNameAndMaxPrice(@Param("keyword") String keyword, @Param("maxPrice") Double maxPrice, Pageable pageable);

    // Native SQL query to count products by category ID
    @Query(value = "SELECT COUNT(*) FROM products WHERE category_id = :categoryId", nativeQuery = true)
    long countByCategoryId(@Param("categoryId") Long categoryId);
}
