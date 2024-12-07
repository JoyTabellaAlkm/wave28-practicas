package com.mercadolibre.athletes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String firstname;
    private String lastname;
    private Integer age;
    private List<Sport> sports;
}
