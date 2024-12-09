package com.mercadolibre.CalCalories.service;

import com.mercadolibre.CalCalories.dto.DishDTO;
import com.mercadolibre.CalCalories.dto.DishResponseDTO;
import com.mercadolibre.CalCalories.dto.IngredientDTO;

import java.util.List;

public interface IDishService {
    public DishResponseDTO calCalories(DishDTO dish);

    public List<DishResponseDTO> calAllCalories(List<DishDTO> dishes);

    public void calIngredientCalories(IngredientDTO ing);
}
