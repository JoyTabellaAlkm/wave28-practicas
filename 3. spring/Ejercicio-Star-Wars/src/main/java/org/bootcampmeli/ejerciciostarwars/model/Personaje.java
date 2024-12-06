package org.bootcampmeli.ejerciciostarwars.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import org.bootcampmeli.ejerciciostarwars.utils.CustomIntegerDeserializer;


@Data
public class Personaje {
    private String name;
    @JsonDeserialize(using = CustomIntegerDeserializer.class)
    private Integer height;
    @JsonDeserialize(using = CustomIntegerDeserializer.class)
    private Integer mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;
}
