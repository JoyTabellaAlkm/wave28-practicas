package com.ejercicios.calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class DishDTO {
    private String name;
    private List<IngredientDTO> ingredients;

}
