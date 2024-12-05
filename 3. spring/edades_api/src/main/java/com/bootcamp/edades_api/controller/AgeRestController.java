package com.bootcamp.edades_api.controller;

import com.bootcamp.edades_api.service.AgeCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgeRestController {

    private AgeCalculatorService ageCalculatorService;

    public AgeRestController(@Autowired AgeCalculatorService ageCalculatorService) {
        this.ageCalculatorService = ageCalculatorService;
    }

    @GetMapping("/{day}/{month}/{year}")
    public String calculateAge(@PathVariable Integer day,
                                @PathVariable Integer month,
                                @PathVariable Integer year) {
        int age = ageCalculatorService.calculateAge(day, month, year);
        return age == -1 ? "Ingrese una fecha válida" : String.valueOf(age);
    }
}
