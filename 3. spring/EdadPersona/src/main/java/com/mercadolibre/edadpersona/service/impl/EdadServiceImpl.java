package com.mercadolibre.edadpersona.service.impl;

import com.mercadolibre.edadpersona.service.IEdadService;
import org.springframework.stereotype.Service;

@Service
public class EdadServiceImpl implements IEdadService {

    @Override
    public int calcularEdad(int dia, int mes, int anio) {

        int diaHoy = 5;
        int mesHoy = 12;
        int anioHoy = 2024;

        int edad = anioHoy - anio -1;

        if(mes < mesHoy) {
            edad += 1;
        } else if (mes == mesHoy && dia <= diaHoy) {
            edad += 1;
        }



        return edad;
    }
}
