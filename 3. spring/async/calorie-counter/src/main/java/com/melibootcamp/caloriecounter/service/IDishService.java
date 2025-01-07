package com.melibootcamp.caloriecounter.service;

import com.melibootcamp.caloriecounter.dto.DishDTO;
import com.melibootcamp.caloriecounter.entity.Ingredient;

import java.util.List;

public interface IDishService {
    public int getPlateTotalCalories(String plateName);
    public List<Ingredient> getPlateIngredients(String plateName);
    public Ingredient getIngredientWithMoreCalories(String plateName);

    public DishDTO getHandler(String platename);
}
