package com.bootcamp.starwars.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonajeDto {
    private String name;

    private int height;

    private int mass;

    private String gender;

    private String homeworld;

    private String species;
}
