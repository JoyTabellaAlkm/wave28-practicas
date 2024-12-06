package com.ar.mercadolibre.ejerciciocovid.model;

import lombok.Data;

@Data
public class Symtom {
    private int code;
    private String name;
    SeverityLevel severityLevel;
}
