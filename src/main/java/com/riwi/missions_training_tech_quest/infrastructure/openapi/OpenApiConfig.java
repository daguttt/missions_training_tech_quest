package com.riwi.missions_training_tech_quest.infrastructure.openapi;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
    @Value("${server.port}")
    private String serverPort;

    @Bean
    public OpenAPI customOpenAPI() {
        // Create a dynamic server URL based on the server port
        String localServerUrl = "http://localhost:" + serverPort;

        // Define the server for OpenAPI
        Server localServer = new Server().url(localServerUrl).description("Local Development Server");

        Info info = new Info().title("Missing training API").version("1.0.0").description(
                "REST API that allows teachers train students through learning missions and assigned skills.");
        return new OpenAPI().servers(Collections.singletonList(localServer)).info(info);
    }
}