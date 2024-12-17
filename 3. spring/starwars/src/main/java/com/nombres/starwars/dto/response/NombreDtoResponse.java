package com.nombres.starwars.dto.response;

import lombok.Data;

@Data
public class NombreDtoResponse {

    private String name;
    private String height;
    private String mass;
    private String gender;
    private String homeworld;
    private String species;

    public NombreDtoResponse(String name, String height, String mass, String gender, String homeworld, String species) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
    }
}
