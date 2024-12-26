package com.mercadolibre.starwars.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
@Data
public class CharacterDTO {
  private String name;
  private String hair_color;
  private String skin_color;
  private String eye_color;
  private String birth_year;
  private String gender;
  private String homeworld;
  private String species;
  private Integer height;
  private Integer mass;

  public CharacterDTO() {
  }

  public CharacterDTO(String name, String hair_color, String skin_color, String eye_color, String birth_year, String gender, String homeworld, String species, Integer height, Integer mass) {
    this.name = name;
    this.hair_color = hair_color;
    this.skin_color = skin_color;
    this.eye_color = eye_color;
    this.birth_year = birth_year;
    this.gender = gender;
    this.homeworld = homeworld;
    this.species = species;
    this.height = height;
    this.mass = mass;
  }

}
