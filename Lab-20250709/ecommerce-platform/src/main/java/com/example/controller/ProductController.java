package com.example.controller;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import com.example.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/search")
    public Page<ProductDTO> searchProducts(
            @RequestParam String keyword,
            @RequestParam BigDecimal maxPrice,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<Product> products = productRepository.searchProducts(keyword, maxPrice, PageRequest.of(page, size));
        List<ProductDTO> dtos = products.stream().map(product -> new ProductDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStock(),
                product.getCategory() != null ? product.getCategory().getId() : null,
                product.getCategory() != null ? product.getCategory().getName() : null
        )).collect(Collectors.toList());
        return new PageImpl<>(dtos, products.getPageable(), products.getTotalElements());
    }

    @GetMapping("/count-by-category/{categoryId}")
    public int countByCategory(@PathVariable Long categoryId) {
        return productRepository.countByCategoryId(categoryId);
    }
}