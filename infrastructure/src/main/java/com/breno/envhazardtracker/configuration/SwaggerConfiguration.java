package com.breno.envhazardtracker.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Environmental Hazard Tracker API")
                        .version("1.0.0")
                        .description("API documentation for the Environmental Hazard Tracker application")
                        .contact(new Contact()
                                .name("Breno")
                                .email("breno@example.com")
                                .url("https://github.com/your-repository")) // Update with your repository
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0.html"))
                )
                .components(new Components());
    }
}
