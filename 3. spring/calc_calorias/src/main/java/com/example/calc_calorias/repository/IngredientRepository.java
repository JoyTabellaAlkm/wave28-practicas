package com.example.calc_calorias.repository;

import com.example.calc_calorias.model.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IngredientRepository {
    List<Ingredient> getIngredientList();
}
