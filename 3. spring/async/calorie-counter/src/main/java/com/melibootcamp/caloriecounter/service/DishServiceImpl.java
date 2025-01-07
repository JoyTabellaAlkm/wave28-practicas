package com.melibootcamp.caloriecounter.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.melibootcamp.caloriecounter.dto.DishDTO;
import com.melibootcamp.caloriecounter.entity.Dish;
import com.melibootcamp.caloriecounter.entity.Ingredient;
import com.melibootcamp.caloriecounter.repository.dish.IDishRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class DishServiceImpl implements IDishService{
    private IDishRepository dishRepository;
    private ObjectMapper objectMapper;

    public DishServiceImpl(IDishRepository dishRepository){
        this.dishRepository = dishRepository;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public DishDTO getHandler(String platename){
        DishDTO toReturn = new DishDTO();
        toReturn.setTotalCalories(getPlateTotalCalories(platename));
        toReturn.setIngredients(getPlateIngredients(platename));
        toReturn.setMostCaloricIngredient(getIngredientWithMoreCalories(platename));
        return toReturn;
    }

    @Override
    public int getPlateTotalCalories(String plateName) {
        try{
            Optional<Dish> toReturn = dishRepository.readAll().stream().filter(x -> x.getName().equals(plateName)).findFirst();
            return toReturn.get().getIngredients().stream().mapToInt(Ingredient::getCalories).sum();
        } catch (Exception e){
            return -1;
        }
    }

    @Override
    public List<Ingredient> getPlateIngredients(String plateName) {
        try{
            Optional<Dish> toReturn = dishRepository.readAll().stream().filter(x -> x.getName().equals(plateName)).findFirst();
            return toReturn.get().getIngredients();
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public Ingredient getIngredientWithMoreCalories(String plateName) {
        try{
            Optional<Dish> toRead = dishRepository.readAll().stream().filter(x -> x.getName().equals(plateName)).findFirst();
            Optional<Ingredient> toReturn= toRead.get().getIngredients().stream().max(Comparator.comparing(Ingredient::getCalories));
            return toReturn.get();
        } catch (Exception e){
            return null;
        }
    }
}
