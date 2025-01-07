package com.melibootcamp.caloriecounter.repository.ingredient;

import com.melibootcamp.caloriecounter.entity.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IIngredientRepository {

    public List<Ingredient> readAll();

    public Ingredient readByName(String name);

}
