package com.bootcamp.ejercicio_starwars.entity;


import com.bootcamp.ejercicio_starwars.utils.CustomIntegerDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Personaje {
    private String name;
    @JsonDeserialize(using = CustomIntegerDeserializer.class)
    private Integer height;
    @JsonDeserialize(using = CustomIntegerDeserializer.class)
    private Integer mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;
}
