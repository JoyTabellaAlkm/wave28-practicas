package com.example.Ejercicio_StarWars.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Personaje {

        @JsonProperty("name")
        private String name;

        @JsonProperty("height")
        private int height;

        @JsonProperty("mass")
        private int mass;

        @JsonProperty("hair_color")
        private String hair_color;

        @JsonProperty("skin_color")
        private String skin_color;

        @JsonProperty("eye_color")
        private String eye_color;

        @JsonProperty("birth_year")
        private String birth_year;

        @JsonProperty("gender")
        private String gender;

        @JsonProperty("homeworld")
        private String homeworld;

        @JsonProperty("species")
        private String species;
}
