package com.bootcamp.ejercicio_covid.dto;

import com.bootcamp.ejercicio_covid.entity.Symptom;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonDto {
    private String name;
    private String surName;
    private int age;
    private List<SymptomDto> syptoms;
}
