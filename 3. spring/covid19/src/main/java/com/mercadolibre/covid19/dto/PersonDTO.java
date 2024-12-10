package com.mercadolibre.covid19.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {
    private String name;
    private String lastName;
    private List<String> symptoms;
}
