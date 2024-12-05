package com.example.Ejercicios_EdadPersonas.Service;

import com.fasterxml.jackson.datatype.jsr310.ser.YearSerializer;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.*;
import java.time.temporal.TemporalUnit;
import java.util.Optional;

@Service
public class EdadService {


    public String calcularEdad(int dia, int mes, int anio){

            LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
            String edad = String.valueOf(fechaNacimiento.until(LocalDate.now()).getYears());
            return edad;


    }
}
