package com.dario.dominguez.cacularcalorias.services.impl;

import com.dario.dominguez.cacularcalorias.entity.Ingredient;
import com.dario.dominguez.cacularcalorias.repository.IIngredientRepository;
import com.dario.dominguez.cacularcalorias.services.IIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService implements IIngredientService {

    @Autowired
    IIngredientRepository ingredientRepository;

    public List<Ingredient> getAllIngredient(){
        return ingredientRepository.getAllIngredients();
    }

}
