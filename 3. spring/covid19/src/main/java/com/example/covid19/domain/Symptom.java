package com.example.covid19.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Symptom {
    private int codigo;
    private String nombre;
    private String nivel_de_gravedad;
}
