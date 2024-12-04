package com.practicExercise.eloApiPowerful.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/roman")
public class RomanToIntegerController {

    @GetMapping("/translate/{romanNumber}")
    public int translate(@PathVariable String romanNumber){
        return (romanNumber.length() == 1) ? singleRomanToInt(romanNumber) : romanToInt(romanNumber);
    }

    private int singleRomanToInt(String romanNumber){
        try{
            return (int) translateDigit(romanNumber.toCharArray()[0]);
        } catch (Exception e) {
            System.out.println( e.getMessage() );
        }
        return 0;
    }

    private int romanToInt(String romanNumber){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(0);
        int reducedNumber = 0;
        for (char digit : romanNumber.toCharArray()){
            Integer translatedDigit = translateDigit(digit);
            numbers.add((translatedDigit.compareTo(numbers.getLast()) < 0) ? translatedDigit : translatedDigit * -1);
        }
        return reducedNumber = -1 * (numbers.stream().reduce(0, Integer::sum));
    }

    private Integer translateDigit(char digit){
        return switch (digit){
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> throw new IllegalArgumentException("Ese no es un numero romano valido");
        };
    }
}
