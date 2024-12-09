package com.mercadolibre.CalCalories.controller;

import com.mercadolibre.CalCalories.dto.DishDTO;
import com.mercadolibre.CalCalories.dto.DishResponseDTO;
import com.mercadolibre.CalCalories.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class calController {
    @Autowired
    IDishService _service;


    @PostMapping("/calculate")
    public DishResponseDTO calculate(@RequestBody DishDTO dish){
        return _service.calCalories(dish);
    }

    @PostMapping("/calculateAll")
    public List<DishResponseDTO> calculate(@RequestBody List<DishDTO> dishes){
        return _service.calAllCalories(dishes);
    }
}
