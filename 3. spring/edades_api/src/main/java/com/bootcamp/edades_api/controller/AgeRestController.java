package com.bootcamp.edades_api.controller;

import com.bootcamp.edades_api.service.IAgeCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgeRestController {

    @Autowired
    private IAgeCalculatorService ageCalculatorService;

    @GetMapping("/{day}/{month}/{year}")
    public String calculateAge(@PathVariable Integer day,
                                @PathVariable Integer month,
                                @PathVariable Integer year) {
        int age = ageCalculatorService.calculateAge(day, month, year);
        return age == -1 ? "Ingrese una fecha válida" : String.valueOf(age);
    }
}
