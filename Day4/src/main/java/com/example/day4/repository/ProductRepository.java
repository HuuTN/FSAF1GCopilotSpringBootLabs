package com.example.day4.repository;

import com.example.day4.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Custom JPQL query: Find products by category name
    @Query("SELECT p FROM Product p WHERE p.category.name = :categoryName")
    List<Product> findByCategoryName(@Param("categoryName") String categoryName);

    // Custom Native SQL query: Find products with price greater than a value
    @Query(value = "SELECT * FROM product WHERE price > :price", nativeQuery = true)
    List<Product> findProductsWithPriceGreaterThan(@Param("price") double price);

    // Pagination: Find all products paginated
    Page<Product> findAll(Pageable pageable);

    // JPQL query: Search products by keyword in name and maximum price
    @Query("SELECT p FROM Product p WHERE p.name LIKE %:keyword% AND p.price <= :maxPrice")
    List<Product> searchByNameAndMaxPrice(@Param("keyword") String keyword, @Param("maxPrice") double maxPrice);

    // Native SQL query: Count products by category ID
    @Query(value = "SELECT COUNT(*) FROM product WHERE category_id = :categoryId", nativeQuery = true)
    int countProductsByCategoryId(@Param("categoryId") Long categoryId);
}
