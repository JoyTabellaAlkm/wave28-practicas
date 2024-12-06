package com.ar.mercadolibre.ejerciciocovid.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Person {
    private int id;
    private String name;
    private String surname;
    private int age;
}
