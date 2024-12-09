package com.example.starwars.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Personaje {
    private String name;
    private Integer height;
    private Integer mass;
    @JsonProperty("hair_color")
    private String hairColor;
    @JsonProperty("skin_color")
    private String skinColor;
    @JsonProperty("eye_color")
    private String eyeColor;
    private String birthYear;
    private String gender;
    private String homeworld;
    private String specie;
}
