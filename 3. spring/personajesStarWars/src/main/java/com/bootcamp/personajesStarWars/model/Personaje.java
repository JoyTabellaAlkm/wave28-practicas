package com.bootcamp.personajesStarWars.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    public void setHeightFromJson(String height){
        try{
            this.height = Integer.parseInt(height);
        } catch (Exception e){
            this.height = null;
        }
    }

    public void setMassFromJson(String height){
        try{
            this.height = Integer.parseInt(height);
        } catch (Exception e){
            this.height = null;
        }
    }
}
