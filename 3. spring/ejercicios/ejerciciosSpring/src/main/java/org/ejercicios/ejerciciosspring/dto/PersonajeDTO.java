package org.ejercicios.ejerciciosspring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PersonajeDTO {
    @JsonProperty("name")
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

    public String getHomeworld() {
        return homeworld;
    }

    public String getGender() {
        return gender;
    }

    public String getMass() {
        return mass;
    }

    public String getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }
}
