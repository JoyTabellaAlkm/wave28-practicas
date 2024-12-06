package com.ar.mercadolibre.ejerciciocovid.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Symptom {
    private int code;
    private String name;
    SeverityLevel severityLevel;
}
