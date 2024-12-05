package co.mercadolibre.calculoedad.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class EdadService {

    public String calcularEdad(int dia, int mes, int anio) {
        if(dia>31 || dia<1 || mes>12 || mes<1) return "Fecha invalida";

        LocalDate nacimiento = LocalDate.of(anio, mes, dia);
        LocalDate actual = LocalDate.now();

        int edad = Period.between(nacimiento, actual).getYears();
        return edad + "";
    }
}
