package com.ejercicios.deportistas.services;

import com.ejercicios.deportistas.dto.DeporteDTO;
import com.ejercicios.deportistas.dto.responses.DeportesYPersonasResponse;

import java.util.List;

public interface IDeporte {

    public List<DeporteDTO> listaDeportes();
    public DeporteDTO encontrarDeporte(String nombre);
    public List<DeportesYPersonasResponse> encontrarDeportesPersonas();

}
