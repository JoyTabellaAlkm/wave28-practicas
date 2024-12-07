package com.meli.starWares.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class PersonajeModel {
    @JsonProperty("name")
    private String name;
    @JsonProperty("height")
    private Integer height;
    @JsonProperty("mass")
    private Integer mass;
    @JsonProperty("hair_color")
    private String hairColor;
    @JsonProperty("skin_color")
    private String skinColor;
    @JsonProperty("eye_color")
    private String eyeColor;
    @JsonProperty("birth_year")
    private String birthYear;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("homeworld")
    private String homeworld;
    @JsonProperty("species")
    private String species;


    @JsonSetter("height")
    public void setHeightFromJSON(String height){
        try {
            this.height = Integer.parseInt(height);
        }catch (NumberFormatException e){
            this.height = null;
        }
    }
    @JsonSetter("mass")
    public void setMassFromJSON(String mass){
        try {
            this.mass = Integer.parseInt(mass);
        }catch (NumberFormatException e){
            this.mass = null;
        }
    }

    public String getName() {
        return null;
    }
}