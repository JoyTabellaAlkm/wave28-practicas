package com.mercadolibre.Star.Wars.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mercadolibre.Star.Wars.util.CustomIntegerDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Personaje {
    @JsonProperty("name")
    private String name;
    @JsonProperty("height")
    @JsonDeserialize(using = CustomIntegerDeserializer.class)
    private Integer height;
    @JsonProperty("mass")
    @JsonDeserialize(using = CustomIntegerDeserializer.class)
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


}
