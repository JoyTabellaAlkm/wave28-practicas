package com.mercadolibre.CalCalories.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.CalCalories.dto.DishDTO;
import com.mercadolibre.CalCalories.dto.DishResponseDTO;
import com.mercadolibre.CalCalories.dto.IngredientDTO;
import com.mercadolibre.CalCalories.entity.FoodEntity;
import com.mercadolibre.CalCalories.repository.IFoodRepository;
import org.springframework.asm.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class DishService implements IDishService{

    @Autowired
    IFoodRepository _repository;

    @Override
    public DishResponseDTO calCalories(DishDTO dish) {
        DishResponseDTO response = new DishResponseDTO(dish);
        int total = 0;
        int maxCalories = 0;
        for (IngredientDTO ingredient : response.getIngredients()) {

            calIngredientCalories(ingredient);
            total += ingredient.getCalories();
            if (ingredient.getCalories() > maxCalories) {
                response.setCaloric(ingredient);
                maxCalories = ingredient.getCalories();
            }
        }
        response.setCalories(total);
        return response;
    }

    @Override
    public List<DishResponseDTO> calAllCalories(List<DishDTO> dishes) {
        List<DishResponseDTO> result = new ArrayList<>();
        for (DishDTO dish : dishes) {
            result.add(this.calCalories(dish));
        }
        return result;
    }

    @Override
    public void calIngredientCalories(IngredientDTO ing) {
        ing.setCalories(0);
        ObjectMapper obj = new ObjectMapper();
        FoodEntity food = _repository.findByName(ing.getName());
        IngredientDTO ingredientFromRepository = new IngredientDTO(
                Integer.parseInt(food.getCalories()),
                food.getName()
        );
        if (ingredientFromRepository != null)
            ing.setCalories((int) (ing.getWeight() * ingredientFromRepository.getCalories() / 100.f));
    }
}
