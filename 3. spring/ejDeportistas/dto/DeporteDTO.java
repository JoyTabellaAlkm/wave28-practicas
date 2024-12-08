package com.mercadolibre.deportistas.dto;

import com.mercadolibre.deportistas.model.Deporte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeporteDTO {

    private String nombre;
    private Integer nivel;

    public DeporteDTO(Deporte deporte) {
        this.nombre = deporte.getNombre();
        this.nivel = deporte.getNivel();
    }

    public static DeporteDTO fromEntity(Deporte deporte) {
        return new DeporteDTO(deporte);
    }
}
