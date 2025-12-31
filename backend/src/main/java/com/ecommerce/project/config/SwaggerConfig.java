package com.ecommerce.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        SecurityScheme bearerScheme = new SecurityScheme()
            .type(SecurityScheme.Type.HTTP)
            .scheme("bearer")
            .bearerFormat("JWT")
            .description("JWT Bearer Token");
        
        SecurityRequirement bearerRequirement = new SecurityRequirement()
            .addList("Bearer Authentication");

        return new OpenAPI()
            .components(new Components()
                .addSecuritySchemes("Bearer Authentication", bearerScheme))
            .addSecurityItem(bearerRequirement);
    }

}
