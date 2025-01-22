package com.example.Starwars.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonajeDto {

    private String name;
    private Integer heihgt;
    private Integer mass;
    private String birthYear;
    private String gender;
    private String homeworld;
    private String species;
}
