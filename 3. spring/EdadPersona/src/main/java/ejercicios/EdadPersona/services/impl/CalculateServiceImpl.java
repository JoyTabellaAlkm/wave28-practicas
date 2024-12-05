package ejercicios.EdadPersona.services.impl;

import ejercicios.EdadPersona.services.ICalculateService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class CalculateServiceImpl implements ICalculateService {

    @Override
    public int calculateAge(int day, int month, int year){
        int result = 0;
        LocalDate fecha = LocalDate.of(year,month,day);
        LocalDate fechaActual = LocalDate.now();

        Period diferencia = Period.between(fecha, fechaActual);
        return diferencia.getYears();

    }

}
