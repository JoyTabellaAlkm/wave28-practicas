package com.caloriescalculatorapi.caloriescalculator.controller;

import com.caloriescalculatorapi.caloriescalculator.dto.RequestDTO;
import com.caloriescalculatorapi.caloriescalculator.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calculate")
public class caloriesCalculatorController {

    @GetMapping("/dish")
    public ResponseEntity<ResponseDTO> calculateDishCalories(@RequestBody RequestDTO requestDTO) {
        return null;
    }

    @GetMapping("/ingredient")
    public ResponseEntity<ResponseDTO> calculateIngredientCalories(@RequestBody RequestDTO requestDTO) {
        return null;
    }


}
