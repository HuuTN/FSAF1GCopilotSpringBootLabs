package com.example;

import com.example.dto.UserDTO;
import com.example.dto.OrderInfoDTO;
import com.example.dto.OrderItemDTO;
import com.example.dto.ProductDTO;
import com.example.constant.OrderStatus;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class EcommerceWorkflowTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private UserDTO testUser;

    @BeforeEach
    void setUp() {
        // Prepare test user data
        testUser = UserDTO.builder()
                .name("John Smith")
                .email("john.smith@example.com")
                .build();
    }

    @Test
    void testFullEcommerceWorkflow() throws Exception {
        // Step 1: Create a new user
        MvcResult createUserResult = mockMvc.perform(post("/api/v1/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testUser)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value(testUser.getName()))
                .andExpect(jsonPath("$.email").value(testUser.getEmail()))
                .andReturn();

        UserDTO createdUser = objectMapper.readValue(
                createUserResult.getResponse().getContentAsString(),
                UserDTO.class);
        assertNotNull(createdUser.getId());

        // Step 2: Search for available products
        BigDecimal maxPrice = new BigDecimal("2000.00");
        MvcResult searchProductsResult = mockMvc.perform(get("/api/v1/products/search")
                .param("keyword", "")
                .param("maxPrice", maxPrice.toString())
                .param("page", "0")
                .param("size", "10"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print()) // This will print the full response
                .andReturn();

        String responseContent = searchProductsResult.getResponse().getContentAsString();
        System.out.println("Raw response: " + responseContent);

        JsonNode root = objectMapper.readTree(responseContent);
        // Check if content node exists
        assertTrue(root.has("content"), "Response should have a 'content' field");
        
        JsonNode contentNode = root.get("content");
        assertTrue(contentNode.isArray(), "Content should be an array");
        
        List<ProductDTO> products = Arrays.asList(
            objectMapper.readValue(contentNode.toString(), ProductDTO[].class)
        );

        // Print the raw data for each product
        contentNode.forEach(node -> {
            System.out.println("Product node: " + node.toString());
        });

        // Print the parsed products
        products.forEach(p -> {
            System.out.println("Parsed product: " + 
                "id=" + p.getId() + 
                ", name=" + p.getName() + 
                ", price=" + p.getPrice() + 
                ", stock=" + p.getStock() + 
                ", categoryId=" + p.getCategoryId() + 
                ", categoryName=" + p.getCategoryName());
        });

        assertNotNull(products, "Products list should not be null");
        assertTrue(!products.isEmpty(), "Should find at least one product");
        assertEquals(3, products.size(), "Should find exactly 3 products from test data");

        // Verify product prices are within range
        assertTrue(products.stream()
                .allMatch(p -> p.getPrice().compareTo(maxPrice) <= 0),
                "All products should be within max price range");
                
        // Verify specific products from test data
        assertTrue(products.stream()
                .anyMatch(p -> p.getName().equals("Smartphone") && 
                        p.getPrice().compareTo(new BigDecimal("699.99")) == 0),
                "Should find Smartphone with correct price");
        assertTrue(products.stream()
                .anyMatch(p -> p.getName().equals("Laptop") && 
                        p.getPrice().compareTo(new BigDecimal("1299.99")) == 0),
                "Should find Laptop with correct price");
        assertTrue(products.stream()
                .anyMatch(p -> p.getName().equals("Java Programming Book") && 
                        p.getPrice().compareTo(new BigDecimal("39.99")) == 0),
                "Should find Java Programming Book with correct price");

        // Step 3: Place an order with multiple items
        List<OrderItemDTO> orderItems = Arrays.asList(
                new OrderItemDTO(products.get(0).getId(), 2),  // 2 pieces of first product
                new OrderItemDTO(products.get(1).getId(), 1)   // 1 piece of second product
        );

        MvcResult placeOrderResult = mockMvc.perform(post("/api/v1/orders")
                .param("userId", createdUser.getId().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(orderItems)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(OrderStatus.PENDING))
                .andExpect(jsonPath("$.customerName").value(createdUser.getName()))
                .andExpect(jsonPath("$.customerEmail").value(createdUser.getEmail()))
                .andReturn();

        OrderInfoDTO createdOrder = objectMapper.readValue(
                placeOrderResult.getResponse().getContentAsString(),
                OrderInfoDTO.class);

        assertNotNull(createdOrder.getOrderId(), "Order ID should not be null");

        // Step 4: Check the order status
        mockMvc.perform(get("/api/v1/orders/{id}", createdOrder.getOrderId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(OrderStatus.PENDING))
                .andExpect(jsonPath("$.orderedBy").value(createdUser.getName()))
                .andExpect(jsonPath("$.products.length()").value(2))
                .andExpect(jsonPath("$.products[0].quantity").value(2))
                .andExpect(jsonPath("$.products[1].quantity").value(1));

        // Step 5: Verify the order appears in pending orders
        MvcResult pendingOrdersResult = mockMvc.perform(get("/api/v1/orders/status/{status}", OrderStatus.PENDING))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[*].orderId", hasItem(createdOrder.getOrderId().intValue())))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        System.out.println("Pending orders response: " + pendingOrdersResult.getResponse().getContentAsString());

        // Step 6: Verify order appears in user's orders
        MvcResult userOrdersResult = mockMvc.perform(get("/api/v1/orders/user/name/{userName}", createdUser.getName()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[*].orderId", hasItem(createdOrder.getOrderId().intValue())))
                .andExpect(jsonPath(String.format("$[?(@.orderId == %d)].customerName", createdOrder.getOrderId()), 
                    hasItem(createdUser.getName())))
                .andExpect(jsonPath(String.format("$[?(@.orderId == %d)].totalAmount", createdOrder.getOrderId()), 
                    hasItem(any(Number.class))))
                .andDo(result -> {
                    System.out.println("User orders response: " + result.getResponse().getContentAsString());
                    System.out.println("Looking for orderId: " + createdOrder.getOrderId());
                    System.out.println("Looking for customerName: " + createdUser.getName());
                })
                .andReturn();

        // Additional verification using the returned data
        String userOrdersContent = userOrdersResult.getResponse().getContentAsString();
        JsonNode ordersNode = objectMapper.readTree(userOrdersContent);
        boolean foundOrder = false;
        
        for (JsonNode order : ordersNode) {
            if (order.get("orderId").asLong() == createdOrder.getOrderId()) {
                foundOrder = true;
                assertEquals(createdUser.getName(), order.get("customerName").asText(), 
                    "Customer name should match");
                assertTrue(order.has("totalAmount"), "Order should have a total amount");
                assertNotNull(order.get("totalAmount").numberValue(), 
                    "Total amount should be a number");
                break;
            }
        }
        
        assertTrue(foundOrder, "Should find the created order in user's orders");
    }
}