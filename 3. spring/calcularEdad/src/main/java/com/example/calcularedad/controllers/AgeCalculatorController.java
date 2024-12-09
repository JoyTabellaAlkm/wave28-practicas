package com.example.calcularedad.controllers;

import com.example.calcularedad.services.AgeCalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping
public class AgeCalculatorController {
    @GetMapping("/{day}/{month}/{year}")
    public Map<String, String> ageCalculator(@PathVariable int day,
                                             @PathVariable int month,
                                             @PathVariable int year) {
        return Map.of("age", AgeCalculatorService.calculateAge(day, month, year));
    }
}
