package com.example.calc_calorias.dto;

import lombok.Data;

import java.util.List;

@Data
public class DishDTO {
    String name;
    List<IngredientDTO> ingredientDTOList;
}
