package com.ejercicios.calorias.repositories;

import com.ejercicios.calorias.models.FoodModel;

import java.util.List;

public interface IFoodRepository {
    public FoodModel findByName(String name);
}
