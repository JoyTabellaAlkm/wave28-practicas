package com.example.calc_calorias.service;

import com.example.calc_calorias.dto.DishDTO;
import com.example.calc_calorias.dto.DishIngredientDTO;
import com.example.calc_calorias.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService{
    @Autowired
    private final IngredientRepository ingredientRepository;
    public DishServiceImpl ( IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<DishIngredientDTO> calculateDishesCalories(List<DishDTO> dishDTOList) {
        return List.of();
    }

    @Override
    //quiero obtener todos los ingredientes de la lista de ingredientes que estén en la dishDTO.getIngredientDTOList
    public DishIngredientDTO calculateDishCalorie(DishDTO dishDTO) {
        return ingredientRepository.getIngredientList().stream()
                .filter(m -> m.getName().equals(dishDTO.getIngredientDTOList()))

    }
}
