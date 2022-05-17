package com.rpnhma.rpnhma_webApplication.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()

                .info(
                        new Info()
                                .title("RPNHMA_forum")
                                .description("Web programiranje projekt")
                                .version("1.0")
                                .license(
                                        new License()
                                                .name("Apache 2.0")
                                                .url("http://www.apache.org/licenses/LICENSE-2.0")));

    }

    @Bean
    public GroupedOpenApi AuthApi() {
        return GroupedOpenApi.builder()
                .group("Authentication")
                .pathsToMatch("/token/**")

                .build();
    }
    @Bean
    public GroupedOpenApi CommentApi() {
        return GroupedOpenApi.builder()
                .group("Comments")
                .pathsToMatch("/comments/**")

                .build();
    }
    @Bean
    public GroupedOpenApi PostsApi() {
        return GroupedOpenApi.builder()
                .group("Posts")
                .pathsToMatch("/posts/**")

                .build();
    }
    @Bean
    public GroupedOpenApi UsersApi() {
        return GroupedOpenApi.builder()
                .group("Users")
                .pathsToMatch("/users/**")

                .build();
    }


}
