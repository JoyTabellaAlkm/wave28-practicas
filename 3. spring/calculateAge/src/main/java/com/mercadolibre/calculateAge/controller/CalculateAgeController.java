package com.mercadolibre.calculateAge.controller;

import com.mercadolibre.calculateAge.service.ICalculaAge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class CalculateAgeController {

    @Autowired
    private ICalculaAge calculateAgeService;

    @GetMapping("/{day}/{month}/{year}")
    public String calculateAge (@PathVariable String day, @PathVariable String month, @PathVariable String year){
        Integer result = calculateAgeService.calculateAge(day, month, year);
        return result == -1 ? "Fecha no valida": String.valueOf(result);
    }
}
