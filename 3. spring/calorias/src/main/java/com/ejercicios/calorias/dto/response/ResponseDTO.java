package com.ejercicios.calorias.dto.response;

import com.ejercicios.calorias.dto.DishDTO;
import com.ejercicios.calorias.dto.IngredientDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseDTO extends DishDTO {
    private Integer totalCalories;
    private List<IngredientDTO> ingredients;
    private IngredientDTO maxCalorieIngredient;
}
