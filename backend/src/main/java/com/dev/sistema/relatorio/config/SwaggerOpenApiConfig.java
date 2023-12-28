package com.dev.sistema.relatorio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@OpenAPIDefinition
public class SwaggerOpenApiConfig {
  
  @Bean
    public OpenAPI baseOpenAPI(){
        return new OpenAPI().info(new Info()
                            .title("Sistema de Gerenciamento de Relatórios")
                            .version("1.0.0").description("Documentação da API com Swagger"));
    }
}
             
