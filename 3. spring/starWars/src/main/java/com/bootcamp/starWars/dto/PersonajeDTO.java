package com.bootcamp.starWars.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PersonajeDTO {
    //@JsonProperty("name")
    private String name;
    @JsonProperty("height")
    private String height;
    @JsonProperty("mass")
    private String mass;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("homeworld")
    private String homeworld;

    public PersonajeDTO(String name, String species, String homeworld, String gender, String mass, String height) {
        this.name = name;
        this.species = species;
        this.homeworld = homeworld;
        this.gender = gender;
        this.mass = mass;
        this.height = height;
    }

    @JsonProperty("species")
    private String species;

    public String getName() {
        return name;
    }
}
