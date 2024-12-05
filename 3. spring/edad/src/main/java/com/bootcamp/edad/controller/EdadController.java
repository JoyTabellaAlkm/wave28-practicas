package com.bootcamp.edad.controller;

import com.bootcamp.edad.service.EdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadController {
    @Autowired
    EdadService edadService;

    @GetMapping("edad/{day}/{month}/{year}")
    public int getAge(@PathVariable int day, @PathVariable int month, @PathVariable int year){
        return edadService.calculateAge(day, month, year);
    }
}
