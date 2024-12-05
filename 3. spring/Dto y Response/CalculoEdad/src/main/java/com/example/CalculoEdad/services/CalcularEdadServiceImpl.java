package com.example.CalculoEdad.services;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;

@Service
public class CalcularEdadServiceImpl implements ICalcularEdadService{
    public CalcularEdadServiceImpl() {
    }
    @Override
    public int calcularEdad(int dia, int mes, int anio) {
        LocalDate fechaDeNacimiento = LocalDate.of(anio, mes, dia);
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaDeNacimiento, fechaActual);
        return periodo.getYears();
    }
}
