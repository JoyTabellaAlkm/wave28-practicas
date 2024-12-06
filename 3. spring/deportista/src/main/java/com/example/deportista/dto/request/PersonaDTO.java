package com.example.deportista.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonaDTO {
    private String name;
    private String lastName;
    private int age;
    private DeporteDTO deporteDto;
}
