package com.example.calcularedad.services;

import java.time.LocalDate;
import java.time.Period;

public class AgeCalculatorService {
    public static String calculateAge(int day, int month, int year){
        LocalDate birthDate = LocalDate.of(year, month, day);

        LocalDate currentDate = LocalDate.now();

        if (birthDate.isAfter(currentDate)) {
            return "La fecha de nacimiento no puede ser en el futuro.";
        }

        Period period = Period.between(birthDate, currentDate);

        return String.valueOf(period.getYears());
    }
}
