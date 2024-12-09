package com.mercadolibre.CalCalories.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.CalCalories.entity.FoodEntity;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FoodRepository implements IFoodRepository{
    @Override
    public FoodEntity findByName(String name) {
        return LoadDatabase().
                stream().
                filter(foodEntity -> foodEntity.getName().equals(name)).
                findFirst().
                get();
    }

    public List<FoodEntity> LoadDatabase(){
        List<FoodEntity> response = new ArrayList<>();
        ObjectMapper obj = new ObjectMapper();
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath::food.json");
        }catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        try{
            response = obj.readValue(file, new TypeReference<List<FoodEntity>>(){});
        }catch (IOException e){
            e.printStackTrace();
        }
        return response;
    }
}
