package com.mercadolibre.calculateAge.service.impl;

import com.mercadolibre.calculateAge.service.ICalculaAge;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

@Service
public class CalculateAgeServiceImpl implements ICalculaAge {

    @Override
    public Integer calculateAge(String day, String month, String year){

        LocalDate dateOfBirth;
        LocalDate currentDate;

        try {
            dateOfBirth = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
            currentDate = LocalDate.now();
            if (dateOfBirth.isAfter(currentDate)){
                throw new DateTimeException("La fecha ingresada es mayor a la actual");
            }
        } catch (DateTimeException | NumberFormatException e){
            return -1;
        }


        Period period = Period.between(dateOfBirth, currentDate);

        return period.getYears();
    }
}
