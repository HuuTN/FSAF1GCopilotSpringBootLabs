package com.example.demo.service;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import com.example.demo.entity.Product;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTddTest {
    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private OrderRepository orderRepository;
    @Mock
    private ProductRepository productRepository;

    @Test
    void testCancelPendingOrderRestoresStock() {
        // Arrange
        Product product = new Product();
        product.setId(1L);
        product.setStock(5);

        OrderItem item = new OrderItem();
        item.setProduct(product);
        item.setQuantity(2);

        Order order = new Order();
        order.setId(100L);
        order.setStatus("PENDING");
        order.setOrderItems(Arrays.asList(item));

        Mockito.when(orderRepository.findById(100L)).thenReturn(Optional.of(order));
        Mockito.when(productRepository.save(Mockito.any(Product.class))).thenAnswer(i -> i.getArgument(0));
        Mockito.when(orderRepository.save(Mockito.any(Order.class))).thenAnswer(i -> i.getArgument(0));

        // Act
        orderService.cancelOrder(100L);

        // Assert
        assertEquals("CANCELLED", order.getStatus());
        assertEquals(7, product.getStock()); // 5 + 2
    }
}
