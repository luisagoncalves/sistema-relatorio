package com.dev.sistema.relatorio.config;

import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@OpenAPIDefinition
public class SwaggerOpenApiConfig {
    @Value("http://localhost:8080")
    private String url;

    @Bean
    public OpenAPI baseOpenAPI() {
        Server server = new Server();
        server.setUrl(url);
        server.setUrl("Swagger URL");

        return new OpenAPI().info(new Info()
                .title("Sistema de Gerenciamento de Relatórios")
                .version("1.0.0").description("Documentação da API"));
    }
}
             
