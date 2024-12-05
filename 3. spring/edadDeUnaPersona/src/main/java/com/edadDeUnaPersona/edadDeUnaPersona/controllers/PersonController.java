package com.edadDeUnaPersona.edadDeUnaPersona.controllers;

import com.edadDeUnaPersona.edadDeUnaPersona.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

        @Autowired
        private PersonServiceImpl person;

        @GetMapping("/calcAge/{day}/{month}/{year}")
        public String calcularEdad(@PathVariable int year, @PathVariable int month, @PathVariable int day){
            int getAge = person.calculateAge(year, month, day);
            return (getAge > 0) ? "Your age is "+ getAge : "Incorrect Date";
        }
}
