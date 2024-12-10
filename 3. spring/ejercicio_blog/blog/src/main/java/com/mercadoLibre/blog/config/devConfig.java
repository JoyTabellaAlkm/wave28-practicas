package com.mercadoLibre.blog.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class devConfig {

    @PostConstruct
    public void initialize(){
        System.out.println("------INICIANDO AMBIENTE DE DEV------");
    }
}
