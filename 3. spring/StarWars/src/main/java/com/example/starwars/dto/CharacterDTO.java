package com.example.starwars.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDTO {
    private String name;
    private Integer height;
    private Integer mass;
    private String birthYear;
    private String gender;
    private String homeworld;
    private String specie;
}
