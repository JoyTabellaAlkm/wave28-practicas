package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.RomanNumberService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/numbers")
public class RomanNumbersController {
    private final RomanNumberService romanNumberService = new RomanNumberService();

    @GetMapping("{enteredNum}")
    public String getRomanNumber(@PathVariable int enteredNum) {
        return romanNumberService.intToRoman(enteredNum);
    }

}
