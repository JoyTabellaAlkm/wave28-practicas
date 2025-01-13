package com.calculate.AgePerson.controller;

import com.calculate.AgePerson.services.CalculateAgeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/age")
public class AgeController {

    @GetMapping("/{day}/{month}/{year}")
    public int calAge (@PathVariable int day, @PathVariable int month, @PathVariable int year){
        return CalculateAgeService.calculateAge(day, month, year);
    }
}
