package com.bootcamp.ejercicio_covid.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
    private Long id;
    private String name;
    private String surName;
    private int age;
    private List<Symptom> syptoms;
}
