package org.bootcampmeli.ejerciciodeportistas.mapper;


import org.bootcampmeli.ejerciciodeportistas.dto.DeporteDTO;
import org.bootcampmeli.ejerciciodeportistas.dto.request.PersonaDTO;
import org.bootcampmeli.ejerciciodeportistas.model.Deporte;
import org.bootcampmeli.ejerciciodeportistas.model.Persona;

public class DeporteMapper {
    public static Deporte mapToDeporte(DeporteDTO deporte) {
        return new Deporte(deporte.getNombre(),deporte.getNivel());
    }
}
