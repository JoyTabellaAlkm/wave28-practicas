package com.example.qatesters.util;

import org.modelmapper.ModelMapper;

public class Utils {

    private static ModelMapper modelMapper;

    public static ModelMapper getModelMapper(){
        if(modelMapper == null){
            modelMapper = new ModelMapper();
        }
        return  modelMapper;
    };
}
