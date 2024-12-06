package com.mercadolibre.covid19.model;

import lombok.Data;

@Data
public class Person {
    private Long id;
    private String firstname;
    private String lastname;
    private Integer age;
}
