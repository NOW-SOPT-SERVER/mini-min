package org.carrot.server.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("당근 마켓 클론 코딩 Swagger")
                .description("NOW SOPT 34th Server Part Seminar 클론 코딩 과제 Swagger입니다.")
                .version("v1");

        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}
