package com.melibootcamp.romannumbers.controllers;

import com.melibootcamp.romannumbers.RomanNumbersApplication;
import com.melibootcamp.romannumbers.repositories.RomanNumbersRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/romanNumbers")
public class RomanNumbersController {

    private RomanNumbersRepository romanNumbersRepository;

    public RomanNumbersController(RomanNumbersRepository romanNumbersRepository){
        this.romanNumbersRepository = romanNumbersRepository;
    }


    @GetMapping("/{number}")
    public String returnRomanNumber(@PathVariable("number") Integer number){
        Optional<String> toReturn = romanNumbersRepository.decimalToRoman(number);
        if(toReturn.isPresent())
        {
            return toReturn.get();
        } else {
            return "COMPUTER BROKE";
        }
    }

}
