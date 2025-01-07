package com.melibootcamp.caloriecounter.dto;

import com.melibootcamp.caloriecounter.entity.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DishDTO {
    private String name;
    private List<Ingredient> ingredients;
    private int totalCalories;
    private Ingredient mostCaloricIngredient;
}
