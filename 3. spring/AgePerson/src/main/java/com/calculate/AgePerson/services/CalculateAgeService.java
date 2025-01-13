package com.calculate.AgePerson.services;

import java.time.LocalDate;
import java.time.Period;

public class CalculateAgeService {

    public static int calculateAge(int day, int month, int year){
        int result = 0;
        LocalDate date = LocalDate.of(year,month,day);
        LocalDate currentDate = LocalDate.now();

        Period difference = Period.between(date, currentDate);
        return difference.getYears();
    }
}
