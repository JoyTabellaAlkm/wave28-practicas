package com.mercadolibre.starwars.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.io.IOException;

@Data
@AllArgsConstructor
@Getter
public class Personaje {
        private String name;
        @JsonDeserialize(using = CustomIntDeserializer.class)
        private Integer height;
        @JsonDeserialize(using = CustomIntDeserializer.class)
        private Integer mass;
        private String hairColor;
        private String skinColor;
        private String eyeColor;
        private String birthYear;
        private String gender;
        private String homeworld;
        private String species;
}

class CustomIntDeserializer extends JsonDeserializer<Integer> {
        @Override
        public Integer deserialize(JsonParser p, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
                String value = p.getText();
                if ("NA".equals(value) || value.isEmpty()) {
                        return null;
                }
                try {
                        return Integer.parseInt(value);
                } catch (NumberFormatException e) {
                        return null;
                }
        }
}