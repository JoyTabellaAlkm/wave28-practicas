package com.ar.mercadolibre.ejerciciocovid.DTO;

import com.ar.mercadolibre.ejerciciocovid.model.SeverityLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SymptomDTO {
    private int code;
    private String name;
    private SeverityLevel severityLevel;
}
