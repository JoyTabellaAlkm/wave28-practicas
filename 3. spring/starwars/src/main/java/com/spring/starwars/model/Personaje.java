package com.spring.starwars.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Personaje {
    private String name;
    private int height;
    private int mass;
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

    @JsonProperty("mass")
    public void setMass(String mass) {
        if ("NA".equals(mass)) {
            this.mass = 0;
        } else {
            try {
                this.mass = Integer.parseInt(mass);
            } catch (NumberFormatException e) {
                this.mass = 0;
            }
        }
    }

    @JsonProperty("height")
    public void setHeight(String height) {
        if ("NA".equals(height)) {
            this.height = 0;
        } else {
            try {
                this.height = Integer.parseInt(height);
            } catch (NumberFormatException e) {
                this.height = 0;
            }
        }
    }
}
