package com.bootcamp.ejercicio_starwars.model;

import lombok.Data;

@Data
public class Personaje {
    private String name;
    private int height;
    private int mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private String homeworld;
    private String species;
}
