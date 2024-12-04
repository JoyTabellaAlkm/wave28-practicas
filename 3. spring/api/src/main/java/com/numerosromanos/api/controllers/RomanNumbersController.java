package com.numerosromanos.api.controllers;

import com.numerosromanos.api.dto.Response;
import com.numerosromanos.api.services.RomanNumberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/romanNumbers")
public class RomanNumbersController {
    @GetMapping
    public Response getRomanNumber(@RequestParam int number){
        return RomanNumberService.numberToRoman(number);
    }
}
