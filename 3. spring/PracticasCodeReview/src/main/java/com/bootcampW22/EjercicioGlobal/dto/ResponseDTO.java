package com.bootcampW22.EjercicioGlobal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDTO {
    Map<String, String> properties = new HashMap<>();

    public void setSingleProperty(String key, String value){
        properties.put(key, value);
    }
}


