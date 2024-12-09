package com.dario.dominguez.cacularcalorias.repository;

import com.dario.dominguez.cacularcalorias.entity.Ingredient;

import java.util.List;

public interface IIngredientRepository {
    public List<Ingredient> getAllIngredients ();
}
