package com.company.permission.admin.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author candylove
 * @date 2024/12/3 14:54
 */
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("permission")
                        .description("springboot basic exercise")
                        .version("v1.0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Spring Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs"));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("admin")
                .pathsToMatch("/admin/**")
                .build();
    }
}
