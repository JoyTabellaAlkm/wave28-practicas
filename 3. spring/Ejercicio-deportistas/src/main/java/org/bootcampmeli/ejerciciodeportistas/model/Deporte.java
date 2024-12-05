package org.bootcampmeli.ejerciciodeportistas.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.bootcampmeli.ejerciciodeportistas.dto.DeporteDTO;

@AllArgsConstructor
@Data
public class Deporte {

    private String nombre;
    private String nivel;


    public DeporteDTO toDTO() {
        return new DeporteDTO(nombre, nivel);

    }
}
