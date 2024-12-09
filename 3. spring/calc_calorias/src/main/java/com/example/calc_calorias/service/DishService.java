package com.example.calc_calorias.service;

import com.example.calc_calorias.dto.DishDTO;
import com.example.calc_calorias.dto.DishIngredientDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DishService {
    List<DishIngredientDTO> calculateDishesCalories(List<DishDTO> dishDTOList);
    DishIngredientDTO calculateDishCalorie(DishDTO dishDTO);
}
