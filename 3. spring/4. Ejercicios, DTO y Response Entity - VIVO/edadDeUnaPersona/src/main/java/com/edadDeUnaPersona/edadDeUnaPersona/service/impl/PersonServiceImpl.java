package com.edadDeUnaPersona.edadDeUnaPersona.service.impl;

import com.edadDeUnaPersona.edadDeUnaPersona.service.IPersonService;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

@Service
public class PersonServiceImpl implements IPersonService {

    @Override
    public int calculateAge(int year, int month, int day){
        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate dateNow = LocalDate.now();

        try{
            if(birthDate.isAfter(dateNow)){
                throw new DateTimeException("Incorrect date");
            }
        }catch (DateTimeException e){
            return -1;
        }

        Period diffBerweenTwoDates = Period.between(birthDate, dateNow);
        return diffBerweenTwoDates.getYears();
    }

}
