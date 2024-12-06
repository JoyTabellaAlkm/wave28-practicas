package com.example.starWars.model;

import com.example.starWars.utils.Deserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Character {
    private String name;
    @JsonDeserialize(using = Deserializer.class)
    private Integer height;
    @JsonDeserialize(using = Deserializer.class)
    private Integer mass;
    @JsonProperty("hair_color")
    private String haiColor;
    @JsonProperty("skin_color")
    private String skinColor;
    @JsonProperty("eye_color")
    private String eyeColor;
    @JsonProperty("birth_year")
    private String birthYear;
    private String gender;
    private String homeworld;
    private String species;
}
