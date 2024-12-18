package com.ejercicios.calorias.repositories;

import com.ejercicios.calorias.models.FoodModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FoodRepositoryImpl implements IFoodRepository {
    private final List<FoodModel> foods;

    public FoodRepositoryImpl() {
        this.foods = loadFoods();
    }

    private List<FoodModel> loadFoods() {
        List<FoodModel> result = new ArrayList<>();
        try (InputStream json = new ClassPathResource("food.json").getInputStream()) {
            ObjectMapper objectMapper = new ObjectMapper();
            result = objectMapper.readValue(json, new TypeReference<>() {
            });
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    @Override
    public FoodModel findByName(String name) {
        return foods.stream()
                .filter(f -> f.getName().equals(name))
                .findFirst().orElse(null);
    }

}
