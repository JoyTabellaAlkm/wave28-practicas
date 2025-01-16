package com.mercadolibre.ejercicioextrashowroom.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateClothesDTO {

    String name;

    String type;

    String brand;

    String color;

    String size;

    Double price;

    Integer quantity;

}
