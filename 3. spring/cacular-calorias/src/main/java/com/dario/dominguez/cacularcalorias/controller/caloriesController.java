package com.dario.dominguez.cacularcalorias.controller;

import com.dario.dominguez.cacularcalorias.entity.Ingredient;
import com.dario.dominguez.cacularcalorias.services.IIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class caloriesController {

    @Autowired
    IIngredientService ingredientService;

    @GetMapping("/ingredients")
    public ResponseEntity<List<Ingredient>> getAllIngredients (){
        return ResponseEntity.status(HttpStatus.OK).body(ingredientService.getAllIngredient());
    }
}
