package com.meli.tienda.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true) // Habilita el mapeo por atributos (en lugar de solo getters/setters)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE) // Permite acceso a atributos privados
                .setSkipNullEnabled(true); // Ignora campos nulos
        return modelMapper;
    }
}
