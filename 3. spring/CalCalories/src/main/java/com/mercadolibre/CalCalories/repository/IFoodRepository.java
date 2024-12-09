package com.mercadolibre.CalCalories.repository;

import com.mercadolibre.CalCalories.entity.FoodEntity;

import java.util.List;

public interface IFoodRepository {
    public FoodEntity findByName(String name);
}
