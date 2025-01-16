package com.mercadolibre.ejercicioextrashowroom.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClothesDTO {

    Long id;

    String name;

    String type;

    String brand;

    String color;

    String size;

    Double price;

    Integer quantity;

}
