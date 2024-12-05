package com.ar.mercadolibre.deportistas.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SportspersonDTO {
    private String name;
    private String surname;
    private SportDTO sport;
}
