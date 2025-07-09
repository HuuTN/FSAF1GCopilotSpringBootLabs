package com.example.lab3;

import com.example.lab3.entity.*;
import com.example.lab3.repository.OrderRepository;
import com.example.lab3.repository.ProductRepository;
import com.example.lab3.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OrderServiceTddTest extends AbstractIntegrationTest {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;

    private Product product;
    private Order order;
    private OrderItem orderItem;
    private int initialStock;

    @BeforeEach
    void setUp() {
        product = new Product();
        product.setName("Test Product");
        product.setStockQuantity(10);
        product.setPrice(new java.math.BigDecimal("100.00"));
        productRepository.save(product);
        initialStock = product.getStockQuantity();

        order = new Order();
        order.setStatus(OrderStatus.PENDING);
        orderRepository.save(order);

        orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setQuantity(2);
        orderItem.setPrice(product.getPrice());
        order.getOrderItems().add(orderItem);
        orderRepository.save(order);
    }

    @Test
    void whenCancelPendingOrder_thenStatusIsCancelledAndStockIsRestored() {
        // Arrange
        Long orderId = order.getId();
        int quantity = orderItem.getQuantity();

        // Act
        orderService.cancelOrder(orderId);

        // Assert
        Order cancelledOrder = orderRepository.findById(orderId).get();
        Product productAfter = productRepository.findById(product.getId()).get();
        assertEquals(OrderStatus.CANCELLED, cancelledOrder.getStatus());
        assertEquals(initialStock + quantity, productAfter.getStockQuantity());
    }
}
