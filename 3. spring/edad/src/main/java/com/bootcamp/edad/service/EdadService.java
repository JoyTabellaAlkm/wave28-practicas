package com.bootcamp.edad.service;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@NoArgsConstructor
@Service
public class EdadService {
    public int calculateAge(int day, int month, int year){
        LocalDate currentDate = LocalDate.now();
        LocalDate inputDate = LocalDate.of(year,month,day);
        Period period = java.time.Period.between(inputDate, currentDate);

        return period.getYears();
    }
}
