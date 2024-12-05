package com.example.covid19.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Person {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private List<Symptom> symptoms;
}
