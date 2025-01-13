package com.mercadolibre.qa_testers.util;

import org.modelmapper.ModelMapper;

public class Utils {
    private static ModelMapper mapper;

    public static ModelMapper getModelMapper(){
        if (mapper == null) mapper = new ModelMapper();
        return mapper;
    }
}
