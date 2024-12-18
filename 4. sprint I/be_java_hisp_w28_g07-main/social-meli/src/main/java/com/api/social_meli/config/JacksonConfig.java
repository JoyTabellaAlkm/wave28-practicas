package com.api.social_meli.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Component;

// Para poder mapear las localDate de los json
@Component
public class JacksonConfig {
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());  // Registra el módulo para manejar fechas Java 8
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // Evita usar timestamps
        return objectMapper;
    }
}