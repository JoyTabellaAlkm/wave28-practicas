package com.mercadolibre.joyeria_las_perlas.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;

public class Utils {
    private static ObjectMapper objectMapper;
    private static ModelMapper modelMapper;

    public static ObjectMapper getObjectMapper(){
        if(objectMapper == null) objectMapper = new ObjectMapper();
        return objectMapper;
    }

    public static ModelMapper getModelMapper() {
        if (modelMapper == null) modelMapper = new ModelMapper();
        return modelMapper;
    }
}
