package com.bootcamp.social_meli;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        title = "Api Social Meli",
        version = "2.0",
        description = "Social Meli information"
))
public class SocialMeliApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialMeliApplication.class, args);
    }

}
