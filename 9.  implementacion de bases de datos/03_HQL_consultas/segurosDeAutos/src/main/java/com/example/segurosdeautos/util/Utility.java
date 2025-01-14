package com.example.segurosdeautos.util;

import org.modelmapper.ModelMapper;

public class Utility {
    private static ModelMapper modelMapper;

    public static ModelMapper getModelMapper() {
        if(modelMapper == null){
            modelMapper = new ModelMapper();
        }
        return modelMapper;
    }
}

