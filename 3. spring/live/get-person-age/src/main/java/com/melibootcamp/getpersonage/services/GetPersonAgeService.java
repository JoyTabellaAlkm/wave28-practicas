package com.melibootcamp.getpersonage.services;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class GetPersonAgeService {

    public GetPersonAgeService(){

    }

    public int calculateAge(LocalDate toCalculate){
        // WIll use Period class to calculate differences between localDates (WHY IS THIS JUST NOT A THING IN LOCALDATE?!?!?)
        Period timeDif = Period.between(toCalculate, LocalDate.now());

        int age = timeDif.getYears();
        return age;
    }

    public LocalDate formatBirthDate(int day, int month, int year){
        LocalDate toReturn = LocalDate.of(year, month, day);
        return toReturn;
    }



}
