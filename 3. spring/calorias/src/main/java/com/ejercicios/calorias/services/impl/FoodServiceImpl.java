package com.ejercicios.calorias.services.impl;

import com.ejercicios.calorias.dto.DishDTO;
import com.ejercicios.calorias.dto.IngredientDTO;
import com.ejercicios.calorias.dto.response.ResponseDTO;
import com.ejercicios.calorias.models.FoodModel;
import com.ejercicios.calorias.repositories.FoodRepositoryImpl;
import com.ejercicios.calorias.repositories.IFoodRepository;
import com.ejercicios.calorias.services.interfaces.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class FoodServiceImpl implements IFoodService {

    private final IFoodRepository foodRepository = new FoodRepositoryImpl();

    @Override
    public ResponseDTO calculate(DishDTO dish) {
        ResponseDTO result = new ResponseDTO();
        List<IngredientDTO> ingredients = calculateIngredientCalories(dish.getIngredients());
        result.setName(dish.getName());
        result.setIngredients(ingredients);
        result.setTotalCalories(result.getIngredients().stream()
                .mapToInt(IngredientDTO::getCalories).sum());
        result.setMaxCalorieIngredient(ingredients.stream()
                .max(Comparator.comparing(IngredientDTO::getCalories)).get());

        return result;
    }

    private List<IngredientDTO> calculateIngredientCalories(List<IngredientDTO> ingredients){
        FoodModel food;
        for (IngredientDTO ingredient : ingredients){
            food = foodRepository.findByName(ingredient.getName());
            if(food != null){
                ingredient.setCalories((int)Math.round((double) food.getCalories()/100 * ingredient.getWeight()));
            }
        }
        return ingredients;
    }
}
