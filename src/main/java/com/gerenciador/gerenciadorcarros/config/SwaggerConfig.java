package com.gerenciador.gerenciadorcarros.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springdoc.core.models.GroupedOpenApi;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("v1") // Nome do grupo para a documentação da API
                .pathsToMatch("/**") // Configura para documentar todos os endpoints
                .build();
    }
}
