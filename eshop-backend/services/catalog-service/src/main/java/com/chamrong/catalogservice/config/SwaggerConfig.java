package com.chamrong.catalogservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {
  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI()
        .info(
            new Info()
                .title("Catalog service API")
                .version("1.0")
                .description(
                    "EShop is ecommerce platform develop by using Spring Boot Java framework.")
                .termsOfService("https://chamrong.com/terms/")
                .license(new License().name("Eshop 1.0").url("https://chamrong.com/license")));
  }
}
