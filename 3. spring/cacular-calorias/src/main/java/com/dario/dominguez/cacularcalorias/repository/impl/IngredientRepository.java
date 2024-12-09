package com.dario.dominguez.cacularcalorias.repository.impl;

import com.dario.dominguez.cacularcalorias.entity.Ingredient;
import com.dario.dominguez.cacularcalorias.repository.IIngredientRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredientRepository implements IIngredientRepository {
    @Override
    public List<Ingredient> getAllIngredients() {

        List<Ingredient> ingredientsList;
        try {
            ObjectMapper mapper = new ObjectMapper();
            //mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE); en caso de que haya un elemento en snake case.
            ingredientsList = mapper.readValue(new File("src/main/resources/food.json"), new TypeReference<List<Ingredient>>() {});
        } catch (Exception e) {
            return new ArrayList<>();
        }
        return ingredientsList;
    }
}
