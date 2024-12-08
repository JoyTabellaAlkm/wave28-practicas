package com.mercadolibre.starwars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonajeDtoResponse {
    String name;
    int height;
    int mass;
    String gender;
    String homeworld;
    String species;
}
