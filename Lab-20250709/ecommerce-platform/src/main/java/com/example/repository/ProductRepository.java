// A Spring Data JPA repository for Product entities.
package com.example.repository;

import com.example.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // A JPQL query to search for products by a keyword in the name and a maximum price.    
    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) AND p.price <= :maxPrice")
    Page<Product> searchProducts(String keyword, BigDecimal maxPrice, Pageable pageable);
    // A native SQL query to count the number of products for a given category ID.
    @Query(value = "SELECT COUNT(*) FROM products WHERE category_id = :categoryId", nativeQuery = true)
    int countByCategoryId(@Param("categoryId") Long categoryId);

}
