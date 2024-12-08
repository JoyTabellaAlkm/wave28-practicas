package com.example.edad.service.implementation;

import com.example.edad.service.IAgeCalculator;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class AgeCalculatorImplementation implements IAgeCalculator {

    @Override
    public int getAge(int day, int month, int year){
        LocalDate date_input = LocalDate.of(year, month, day);
        LocalDate cur = LocalDate.now();
        return Period.between(date_input, cur).getYears();
    }
}
