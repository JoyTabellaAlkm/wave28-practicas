package com.spring.ejercicios.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Deporte {
    private String nombre;
    private String nivel;
}
