package com.bootcamp.obtenerEdad;

import org.springframework.stereotype.Service;

@Service
public class EdadServicio {
    public int obetenerEdad(int año, int mes, int dia){
        int añoActual =2024;
        int mesActual= 11;
        int diaActual= 6;
        boolean cumplioAños=false;

        if(mes>= mesActual){
            if (dia>=  diaActual){
                cumplioAños = true;
            }
        }

        int edad = cumplioAños? (añoActual-año) : (añoActual - año -1);

        return edad;
    }

}
