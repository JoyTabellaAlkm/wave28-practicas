package com.melibootcamp.caloriecounter.repository.ingredient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.melibootcamp.caloriecounter.entity.Dish;
import com.melibootcamp.caloriecounter.entity.Ingredient;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientRepositoryImpl implements IIngredientRepository {
    private ObjectMapper objectMapper;
    private List<Ingredient> ingredientList;

    public IngredientRepositoryImpl(){
        ingredientList = new ArrayList<>();
        objectMapper = new ObjectMapper();
        try{
            File toRead= ResourceUtils.getFile("classpath:food.json");
            ingredientList = objectMapper.readValue(toRead, new TypeReference<List<Ingredient>>() {});
        } catch (Exception e){
            System.out.println("Couldn't read the JSON file");
        }
    }


    @Override
    public List<Ingredient> readAll() {
        return ingredientList;
    }

    @Override
    public Ingredient readByName(String name) {
        Optional<Ingredient> toReturn = ingredientList.stream().filter(x -> x.getName().toLowerCase().equals(name.toLowerCase())).findFirst();
        if (toReturn.isPresent()){
            return toReturn.get();
        }
        return null;
    }

}
