package com.example.goldshop.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SpringDocumetConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI().info(
                new Info()
                        .title("Xanmemmedova Shefiqe")
                        .version("0.0.1")
                        .description("Bu servis GoldShop sayti ucun yazilib")
                        .contact(
                                new Contact()
                                .name("Xanmemmedova Shefiqe")
                                        .email("xanmemmedovasefiqe@gmail.com"))
        );
    }
}
