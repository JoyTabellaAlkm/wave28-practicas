package com.ar.mercadolibre.ejerciciocovid.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class PatientDTO {
    private int id;
    private String name;
    private String surname;
    private int age;
    private List<SymptomDTO> symptoms;
}
