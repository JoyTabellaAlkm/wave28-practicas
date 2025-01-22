package com.example.Starwars.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @JsonProperty("birth_year")
    private String birthYear;
    private String gender;
    private String homeworld;
    private String species;

    @JsonSetter("height")
    public void setHeight(String height){
        try {
            this.height = Integer.parseInt(height);
        }catch (NumberFormatException e){
            this.height = null;
        }
    }

    @JsonSetter("mass")
    public void setMass(String mass){
        try {
            this.mass = Integer.parseInt(mass);
        }catch (NumberFormatException e){
            this.mass = null;
        }
    }
}
