package com.melibootcamp.caloriecounter.controller;

import com.melibootcamp.caloriecounter.dto.DishDTO;
import com.melibootcamp.caloriecounter.entity.Dish;
import com.melibootcamp.caloriecounter.service.IDishService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calorie")
public class CalorieCounterController {
    private IDishService dishService;

    public CalorieCounterController(IDishService dishService){
        this.dishService = dishService;
    }

    @GetMapping()
    public ResponseEntity<?> getPlateData(@RequestParam String platename){
        DishDTO toReturn = dishService.getHandler(platename);
        return new ResponseEntity<>(toReturn, HttpStatus.OK);
    }


}
