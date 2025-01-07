package com.melibootcamp.getpersonage.controllers;

import com.melibootcamp.getpersonage.services.GetPersonAgeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/getPersonAge")
public class GetPersonAgeController {


    private GetPersonAgeService getPersonAgeService;

    public GetPersonAgeController(GetPersonAgeService getPersonAgeService){
        this.getPersonAgeService = getPersonAgeService;
    }

    @GetMapping("/doIt/{day}-{month}-{year}")
    public int getPersonAge(@PathVariable int day, @PathVariable int month, @PathVariable int year){
        return getPersonAgeService.calculateAge(getPersonAgeService.formatBirthDate(day, month, year));
    }

}
