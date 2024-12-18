package com.caloriescalculatorapi.caloriescalculator.service;

import com.caloriescalculatorapi.caloriescalculator.dto.DishDTO;
import com.caloriescalculatorapi.caloriescalculator.dto.ResponseDTO;
import com.caloriescalculatorapi.caloriescalculator.model.Ingredient;

import java.util.List;

public interface ICaloriesCalculator {

    public Ingredient getIngredients();

    public ResponseDTO calculateDishes(List<DishDTO> dishes);



}
