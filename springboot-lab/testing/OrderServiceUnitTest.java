package com.example.demo.testing;

import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.OrderServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderServiceUnitTest {
    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImp orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCancelOrder_OrderExists() {
        Long orderId = 1L;
        Order order = new Order();
        order.setId(orderId);
        when(orderRepository.findById(orderId)).thenReturn(Optional.of(order));

        assertDoesNotThrow(() -> orderService.cancelOrder(orderId));
        verify(orderRepository, times(1)).delete(order);
    }

    @Test
    void testCancelOrder_OrderNotFound() {
        Long orderId = 2L;
        when(orderRepository.findById(orderId)).thenReturn(Optional.empty());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> orderService.cancelOrder(orderId));
        assertTrue(exception.getMessage().contains("Order not found"));
        verify(orderRepository, never()).delete(any());
    }
}
