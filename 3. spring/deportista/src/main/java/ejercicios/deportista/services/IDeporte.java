package ejercicios.deportista.services;

import ejercicios.deportista.dto.DeporteDTO;
import ejercicios.deportista.dto.responses.DeportesYPersonasResponse;

import java.util.List;

public interface IDeporte {

    public List<DeporteDTO> listaDeportes();
    public DeporteDTO encontrarDeporte(String nombre);
    public List<DeportesYPersonasResponse> encontrarDeportesPersonas();

}
