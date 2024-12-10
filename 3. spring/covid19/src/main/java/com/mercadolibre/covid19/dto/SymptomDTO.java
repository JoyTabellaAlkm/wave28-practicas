package com.mercadolibre.covid19.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SymptomDTO {
    private Integer code;
    private String name;
    private Integer levelOfSeverity;
}
