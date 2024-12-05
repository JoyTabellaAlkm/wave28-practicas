package com.mercadolibre.obteneredad.Service.Implementation;

import com.mercadolibre.obteneredad.Service.IObtenerEdadService;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;

@Service
public class ObtenerEdadServiceImpl implements IObtenerEdadService {

    @Override
    public int CalculoEdad(int dia, int mes, int anio) {

        int edad;
        int concatenarMesDia = mes * 100 + dia;
        int concatenarMesDiaHoy = LocalDate.now().getMonth().getValue() * 100 + LocalDate.now().getDayOfMonth();

        try{
            LocalDate.of(anio, mes, dia);
            if (concatenarMesDia > concatenarMesDiaHoy) {
                edad = LocalDate.now().getYear() - anio - 1;
            } else {
                edad = LocalDate.now().getYear() - anio;
            }

            if(edad < 0) throw new DateTimeException("Fecha futura");

            return edad;
        }catch(DateTimeException e) {
            return -1;
        }
    }
}
