package com.example.dto;

import com.example.enums.OrderStatus;

import jakarta.validation.constraints.NotNull;

public class OrderDTO {
    private Long id;

    @NotNull(message = "Order status is required")
    private OrderStatus status;

    public OrderDTO() {}

    public OrderDTO(Long id, OrderStatus status) {
        this.id = id;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}