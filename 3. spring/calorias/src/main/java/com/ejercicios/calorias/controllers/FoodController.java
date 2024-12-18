package com.ejercicios.calorias.controllers;

import com.ejercicios.calorias.dto.DishDTO;
import com.ejercicios.calorias.services.interfaces.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {

    @Autowired
    private IFoodService foodService;

    @PostMapping("/calculate")
    public ResponseEntity<?> calculateCalories(@RequestBody DishDTO dish){
        return ResponseEntity.ok(foodService.calculate(dish));
    }

}
