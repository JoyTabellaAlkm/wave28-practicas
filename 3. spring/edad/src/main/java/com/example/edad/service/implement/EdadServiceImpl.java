package com.example.edad.service.implement;

import com.example.edad.service.IEdadService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EdadServiceImpl implements IEdadService {

    private static LocalDate fechaActual = LocalDate.now();
    @Override
    public String calcularEdad(int dia, int mes, int anio){
        try{
            LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
            int edad = fechaActual.getYear() - fechaNacimiento.getYear();
            return "Su edad es: " + edad;
        }catch (Exception e){
            return "Error";
        }
    }
}
