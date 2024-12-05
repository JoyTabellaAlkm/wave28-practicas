package com.bootcamp.deportistas.mapper;

import com.bootcamp.deportistas.domain.Deporte;
import com.bootcamp.deportistas.dto.DeporteDTO;

public class DeporteMapper {
    public static DeporteDTO mapToDeporteDTO(Deporte deporte) {
        return new DeporteDTO(deporte.getNombre(), deporte.getNivel());
    }
}
