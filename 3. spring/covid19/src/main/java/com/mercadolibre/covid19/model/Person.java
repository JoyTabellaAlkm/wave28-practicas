package com.mercadolibre.covid19.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private Integer id;
    private String name;
    private String lastName;
    private Integer age;
    private List<Symptom> symptoms;
}
