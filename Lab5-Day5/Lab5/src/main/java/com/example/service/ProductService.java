package com.example.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.dto.ProductDTO;
import com.example.entity.Product;

public interface ProductService {
    List<Product> getAllProducts();
    Page<Product> getAllProducts(Pageable pageable);
    Optional<Product> getProductById(Long id);
    Product createProduct(ProductDTO productDTO);
    Optional<Product> updateProduct(Long id, ProductDTO productDTO);
    boolean deleteProduct(Long id);
}
