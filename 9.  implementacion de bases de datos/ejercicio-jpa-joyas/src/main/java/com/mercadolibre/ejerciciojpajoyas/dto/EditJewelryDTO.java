package com.mercadolibre.ejerciciojpajoyas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditJewelryDTO {
    String name;

    String material;

    Double weight;

    String description;

    Boolean hasStone;

}
