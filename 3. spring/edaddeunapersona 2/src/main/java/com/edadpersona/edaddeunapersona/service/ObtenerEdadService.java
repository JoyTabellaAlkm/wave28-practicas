package com.edadpersona.edaddeunapersona.service;

@lombok.NoArgsConstructor
public class ObtenerEdadService {
    public int calcularEdad(int day, int month, int year){
        java.time.LocalDate fechaActual = java.time.LocalDate.now();

        java.time.LocalDate fechaNacimiento = java.time.LocalDate.of(year,month,day);

        // Calcular la diferencia entre las fechas
        java.time.Period periodo = java.time.Period.between(fechaNacimiento, fechaActual);

        // Obtener la edad en años
        int edad = periodo.getYears();

        return edad;
    }
}
