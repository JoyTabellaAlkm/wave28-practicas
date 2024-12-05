package ejercicios.EdadPersona.controllers;

import ejercicios.EdadPersona.services.ICalculateService;
import ejercicios.EdadPersona.services.impl.CalculateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
public class CalAgeController {

    @Autowired
    private ICalculateService service;

    @GetMapping("/calAge/{day}/{month}/{year}")
    public int calAge(@PathVariable int day,@PathVariable int month,@PathVariable int year
    ){
        return service.calculateAge(day,month,year);
    }
}
