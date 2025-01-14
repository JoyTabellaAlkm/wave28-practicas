package com.mercadolibre.covid19.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RiskPersonDto {
    private String firstname;
    private String lastname;
    private List<String> symptoms;
}
