package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.annotations.EnableOpenApi;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Bean
    @ConditionalOnProperty(name = "swagger.enabled", havingValue = "true")
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info().title("API Docs").version("v1"));
    }
}
