package com.trading.config;



import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI stockTradingOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Stock Trading Order Engine API")
                        .description("Backend API for stock trading order matching engine")
                        .version("1.0"));
    }

}
