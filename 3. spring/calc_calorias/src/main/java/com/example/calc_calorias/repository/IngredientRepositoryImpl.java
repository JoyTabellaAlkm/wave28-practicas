package com.example.calc_calorias.repository;

import com.example.calc_calorias.model.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class IngredientRepositoryImpl implements IngredientRepository{
    @Override
    public List<Ingredient> getIngredientList() {
        List<Ingredient> ingredients;

        try {
            ObjectMapper mapper = new ObjectMapper();
            ingredients = mapper.readValue(new File("src/main/java/com/example/calc_calorias/repository/food.json"), new TypeReference<List<Ingredient>>() {});
        } catch (Exception e) {
            return new ArrayList<>();
        }

        return ingredients;
    }
}
