package com.sopt.collaboration.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SOPT 38기 합동 세미나 API")
                        .version("v1")
                        .description("LET'S SOPT 38기 합동세미나 모바일 웹 2조 네이버"))
                .servers(List.of(new Server().url("https://sopt-naver2.p-e.kr")));
    }
}
