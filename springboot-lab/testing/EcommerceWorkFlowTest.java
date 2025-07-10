package com.example.demo.testing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;

@SpringBootTest
@AutoConfigureMockMvc
public class EcommerceWorkFlowTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void applicationContextLoads() throws Exception {
        // Example: check if health endpoint is available in full context
        mockMvc.perform(get("/api/health"))
                .andExpect(status().isOk());
    }

    @Test
    void endToEndOrderPlacement() throws Exception {
        // 1. Create user
        String userJson = "{" +
                "\"username\": \"testuser\"," +
                "\"email\": \"testuser@example.com\"}";
        String userResponse = mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userJson))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        Long userId = com.fasterxml.jackson.databind.JsonNode.class.cast(
                new com.fasterxml.jackson.databind.ObjectMapper().readTree(userResponse)).get("id").asLong();

        // 2. Create product
        String productJson = "{" +
                "\"name\": \"Test Product\"," +
                "\"price\": 99.99}";
        String productResponse = mockMvc.perform(post("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(productJson))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        Long productId = com.fasterxml.jackson.databind.JsonNode.class.cast(
                new com.fasterxml.jackson.databind.ObjectMapper().readTree(productResponse)).get("id").asLong();

        // 3. Create order
        String orderJson = String.format("{" +
                "\"user\": {\"id\": %d}," +
                "\"items\": [{\"product\": {\"id\": %d}, \"quantity\": 1, \"price\": 99.99}]" +
                "}", userId, productId);
        String orderResponse = mockMvc.perform(post("/api/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(orderJson))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        Long orderId = com.fasterxml.jackson.databind.JsonNode.class.cast(
                new com.fasterxml.jackson.databind.ObjectMapper().readTree(orderResponse)).get("id").asLong();

        // 4. Process order
        mockMvc.perform(post("/api/orders/" + orderId + "/process"))
                .andExpect(status().isOk());

        // 5. Verify order exists for user
        mockMvc.perform(get("/api/orders/user/" + userId))
                .andExpect(status().isOk());
    }
}
