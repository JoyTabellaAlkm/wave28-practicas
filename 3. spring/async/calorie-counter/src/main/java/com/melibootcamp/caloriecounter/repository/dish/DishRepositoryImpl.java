package com.melibootcamp.caloriecounter.repository.dish;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.melibootcamp.caloriecounter.entity.Dish;
import com.melibootcamp.caloriecounter.entity.Ingredient;
import com.melibootcamp.caloriecounter.repository.ingredient.IngredientRepositoryImpl;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class DishRepositoryImpl implements IDishRepository{
    private ObjectMapper objectMapper;
    private IngredientRepositoryImpl ingredientRepository;
    private List<Dish> dishList;

    public DishRepositoryImpl(){
        dishList = new ArrayList<>();
        objectMapper = new ObjectMapper();
        ingredientRepository = new IngredientRepositoryImpl();
        fillRepository();
    }


    @Override
    public List<Dish> readAll() {
        return dishList;
    }

    public boolean fillRepository(){
        try{
            List<Ingredient> toAdd = new ArrayList<>();
            toAdd.add(ingredientRepository.readByName("pollo"));
            toAdd.add(ingredientRepository.readByName("tomates"));
            toAdd.add(ingredientRepository.readByName("lechuga"));
            toAdd.add(ingredientRepository.readByName("cebolla"));


            dishList.add(new Dish("Pollo con Ensalada",toAdd));

            toAdd.clear();

            toAdd.add(ingredientRepository.readByName("leche entera"));
            toAdd.add(ingredientRepository.readByName("harina de trigo refinada"));
            toAdd.add(ingredientRepository.readByName("huevo entero"));
            toAdd.add(ingredientRepository.readByName("azúcar"));
            toAdd.add(ingredientRepository.readByName("chocolate sin leche"));

            dishList.add(new Dish("Torta de Chocolate", toAdd));

            toAdd.clear();

            toAdd.add(ingredientRepository.readByName("salchicha frankfurt"));
            toAdd.add(ingredientRepository.readByName("pan de trigo blanco"));
            toAdd.add(ingredientRepository.readByName("mostaza"));
            toAdd.add(ingredientRepository.readByName("mayonesa"));

            dishList.add(new Dish("Pancho", toAdd));

            return true;
        }catch (Exception e){
            return false;
        }
    }
}
