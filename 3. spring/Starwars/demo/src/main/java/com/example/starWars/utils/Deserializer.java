package com.example.starWars.utils;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class Deserializer extends JsonDeserializer {

    @Override
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        String value = jsonParser.getText().trim();

        if("NA".equalsIgnoreCase(value)) {
            return null;
        }

        try {
            return Integer.parseInt(value);
        }
        catch(NumberFormatException e) {
            return null;
        }
    }
}
