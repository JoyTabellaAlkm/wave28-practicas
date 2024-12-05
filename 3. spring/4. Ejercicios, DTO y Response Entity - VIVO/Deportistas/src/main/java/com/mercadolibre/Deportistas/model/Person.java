package com.mercadolibre.Deportistas.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Person {
    private String name;
    private String lastName;
    private Integer age;
    private Sport sport;
}
