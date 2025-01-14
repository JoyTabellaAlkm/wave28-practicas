package com.mercadolibre.ejerciciohql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorDTO {

    Long id;

    String firstName;

    String lastName;

    Double rating;

}
