package com.example.starwars.model;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Personaje {
    private String name;
    @JsonDeserialize(using = CustomIntDeserializer.class)
    private Integer height;
    @JsonDeserialize(using = CustomIntDeserializer.class)
    private Integer mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private String homeworld;
    private String species;
}

