package com.bootcamp.edades_api.service;

import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

@Service
public class AgeCalculatorService {

    public Integer calculateAge(int day, int month, int year){
        LocalDate birthDate;
        LocalDate currentDate;
        try {
            birthDate = LocalDate.of(year, month, day);
            currentDate = LocalDate.now();
            if (birthDate.isAfter(currentDate)) {
                throw new DateTimeException("La fecha ingresada es en el futuro");
            }
        } catch (DateTimeException dateTimeException) {
            return -1;
        }
        Period period = Period.between(birthDate, currentDate);
        return period.getYears();
    }
}
