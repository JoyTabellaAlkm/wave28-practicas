package ejercicios.deportista.services;

import ejercicios.deportista.dto.DeporteDTO;

import java.util.List;

public interface IDeporte {

    public List<DeporteDTO> encontrarDeportes();
}
