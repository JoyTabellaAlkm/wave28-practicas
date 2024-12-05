package com.ar.mercadolibre.deportistas.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Person {

    private String name;
    private String surname;
    private int age;
}
