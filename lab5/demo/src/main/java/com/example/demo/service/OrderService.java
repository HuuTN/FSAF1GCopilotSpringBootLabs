package com.example.demo.service;

import com.example.demo.entity.Order;

import com.example.demo.dto.OrderDTO;

public interface OrderService {
    void cancelOrder(Long orderId);
    Order placeOrder(Order order);
    Order createOrder(OrderDTO orderDTO);
}
