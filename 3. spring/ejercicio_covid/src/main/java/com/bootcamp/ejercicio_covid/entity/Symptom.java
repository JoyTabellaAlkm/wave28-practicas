package com.bootcamp.ejercicio_covid.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Symptom {
    private Long code;
    private String name;
    private String gravityLevel;
}
