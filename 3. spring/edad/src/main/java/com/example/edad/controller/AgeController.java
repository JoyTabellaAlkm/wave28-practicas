package com.example.edad.controller;


import com.example.edad.service.IAgeCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgeController {
    @Autowired
    private IAgeCalculator ageCalculator;

    @GetMapping("/{day}/{month}/{year}")
    public int getAge(@PathVariable int day, @PathVariable int month, @PathVariable int year) {
        return ageCalculator.getAge(day, month, year);
    }
}
