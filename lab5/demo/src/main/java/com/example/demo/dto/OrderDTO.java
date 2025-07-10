package com.example.demo.dto;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {
    private Long customerId;
    private List<com.example.demo.dto.OrderItemDTO> items;
}
