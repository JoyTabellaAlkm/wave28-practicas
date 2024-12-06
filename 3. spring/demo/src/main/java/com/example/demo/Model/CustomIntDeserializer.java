package com.example.demo.Model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class CustomIntDeserializer extends JsonDeserializer<Integer> {

    @Override
    public Integer deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getText();
        if ("NA".equals(value) || value.trim().isEmpty()) {
            return 0; // Reemplaza "NA" o cualquier cadena vacía por 0
        }
        try {
            return Integer.parseInt(value); // Convierte el valor en un entero
        } catch (NumberFormatException e) {
            return 0; // Si la cadena no es un número válido, asigna 0
        }
    }
}
