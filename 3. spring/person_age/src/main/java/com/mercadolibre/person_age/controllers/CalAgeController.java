package com.mercadolibre.person_age.controllers;

import com.mercadolibre.person_age.services.CalculateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
public class CalAgeController {


    @GetMapping("/calAge/{day}/{month}/{year}")
    public int calAge(@PathVariable int day,@PathVariable int month,@PathVariable int year){
        return CalculateService.calculateAge(day,month,year);
    }
}
