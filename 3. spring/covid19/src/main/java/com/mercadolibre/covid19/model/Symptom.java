package com.mercadolibre.covid19.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Symptom {
    private Integer code;
    private String name;
    private Integer levelOfSeverity;
}
